package by.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(path = "/calc")
public class CalcController {

    @Autowired
    private CalcService calcService;

    @Autowired
    private HistoryService historyService;

    @GetMapping
    public ModelAndView get(ModelAndView modelAndView) {
        modelAndView.addObject("flag", false);
        modelAndView.setViewName("calc");
        modelAndView.addObject("operation", new Operation());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView post(@Valid Operation operation, BindingResult bindingResult, HttpSession session, ModelAndView model) {
        if (bindingResult.hasErrors()){
            model.setViewName("calc");
            return model;
        }
        Double calc = calcService.calc(operation.getNum1(), operation.getNum2(), operation.getOperation());
//        if (calc == 0){
//            model.addObject("flag", true);
//            return model;
//        }
        historyService.add(operation.getNum1(), operation.getNum2(), operation.getOperation(), calc, ((User) session.getAttribute("currentUser")));
        model.addObject("result", calc);
        model.setViewName("calc");
        return model;
    }
}
