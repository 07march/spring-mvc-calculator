package by.learn;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Controller
@RequestMapping(path = "/main")
@Validated
public class MainController {

    @GetMapping
    public ModelAndView hello(@NotEmpty @Size(min = 6) String name, WebRequest webRequest, ModelAndView model) {
        model.setViewName("hello");
        model.addObject("message", "Hello " + name + "!");
        return model;
    }
}
