package by.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Size;

@Controller
@RequestMapping(path = "/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/reg")
    public ModelAndView registration(ModelAndView model) {
        model.addObject("user", new User());
        model.setViewName("reg");
        return model;
    }

    @PostMapping(path = "/reg")
    public ModelAndView registration(@Valid User user, BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("reg");
            return modelAndView;
        }
        userService.add(new User(user.getName(), user.getLogin(), user.getPassword(), user.getAge()));
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @GetMapping(path = "/cabinet")
    public String cabinet() {
        return "cabinet";
    }

    @GetMapping(path = "/auth")
    public String authorization() {
        return "auth";
    }

    @PostMapping(path = "/auth")
    public String autorization(String login, String password, HttpSession httpSession, Model model) {
        System.out.println(httpSession.getClass());
        User byLogin = userService.findByLogin(login);
        if (userService.findByLogin(login) == null) {
            model.addAttribute("message", "incorrect login! Try again!");
            return "auth";
        } else if (byLogin.getPassword().equals(password)) {
            httpSession.setAttribute("currentUser", byLogin);
            return "redirect:/";
        } else {
            model.addAttribute("message", "incorrect password! Try again!");
            return "auth";
        }
    }

    @GetMapping(path = "/upname")
    public String updateUserName() {
        return "upusername";
    }

    @PostMapping(path = "/upname")
    public String updateUserName(@Size(min = 3, max = 10) @RequestParam String name, HttpSession session) {
        userService.updateName(name, ((User) session.getAttribute("currentUser")).getId());
        return "redirect:/";
    }

    @GetMapping(path = "/uplogin")
    public String updateUserLogin() {
        return "upuserlogin";
    }

    @PostMapping(path = "/uplogin")
    public String updateUserLogin(@Size(min = 3, max = 10) @RequestParam String login, HttpSession session) {
        userService.updateLogin(login, ((User) session.getAttribute("currentUser")).getId());
        return "redirect:/";
    }

    @GetMapping(path = "/uppassword")
    public String updateUserPassword() {
        return "upuserpassword";
    }

    @PostMapping(path = "/uppassword")
    public String updateUserPassword(@Size(min = 3, max = 10) @RequestParam String password, HttpSession session, Model model) {
        boolean currentUser = userService.updatePassword(password, ((User) session.getAttribute("currentUser")).getId());
        if (!currentUser) {
            model.addAttribute("message", "Error");
            return "upuserpassword";
        }
        return "redirect:/";
    }

    @GetMapping(path = "/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }
}
