package com.github.nosachigor23.shoponline.contrloller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Controller
public class ExceptionHandlerController {

    private static final Logger LOG = Logger.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, ModelAndView modelAndView) {
        System.out.println("---------------------------------------------------");
        LOG.error("Error: " + e.getMessage(), e);
        modelAndView.addObject("exception", e.getMessage());
        return "redirect:/";
    }
}
