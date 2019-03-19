package edu.mum.meditaion_attendance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(value = HttpStatus.NOT_FOUND , reason = "IOException occured")
    @ExceptionHandler(IOException.class)
    public String handleIoException(){

        logger.error("Page not found ");
        return "errorPages/error-404";
    }
}
