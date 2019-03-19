package edu.mum.meditaion_attendance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(value = HttpStatus.NOT_FOUND , reason = "IOException occured")
    @ExceptionHandler(IOException.class)
    @ModelAttribute
    public ModelAndView handleIoException(){

        ModelAndView modelAndView= new ModelAndView();
        logger.error("Page not found ");
        modelAndView.setViewName("errorPages/error-404");
        return modelAndView;
    }
}
