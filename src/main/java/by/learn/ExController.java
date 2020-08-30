package by.learn;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ExController {

    @ExceptionHandler(UserNorFoundException.class)
    public ModelAndView ex(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", e.getMessage());
        modelAndView.setViewName("errorPage");
        return modelAndView;
    }

    //    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ModelAndView ex2(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Invalid parameters");
        modelAndView.setViewName("errorPage");
        return modelAndView;
    }

//    @ExceptionHandler(Exception.class)
//    public ModelAndView m(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("message", e.getMessage());
//        modelAndView.setViewName("errorPage");
//        return modelAndView;
//    }
}
