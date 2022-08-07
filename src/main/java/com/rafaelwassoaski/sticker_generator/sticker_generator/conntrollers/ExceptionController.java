package com.rafaelwassoaski.sticker_generator.sticker_generator.conntrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler
    @ResponseBody
    protected String handleFileError(RuntimeException ex, WebRequest req){
        System.out.println(ex.getMessage());
        System.out.println("Teste");

        return "deu erro";
    }
}
