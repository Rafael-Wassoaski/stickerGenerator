package com.rafaelwassoaski.sticker_generator.sticker_generator.conntrollers;

import com.rafaelwassoaski.sticker_generator.sticker_generator.exceptions.TextToLargeException;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler
    protected String handleTextSizeError(Exception ex, WebRequest req, Model model){
        String fileError = ex.getMessage();
        model.addAttribute("fileError", fileError);

        return "ErrorPage";
    }
    
    @ExceptionHandler({FileSizeLimitExceededException.class})
    protected String handleFileError(RuntimeException ex, WebRequest req, Model model){
        System.out.println(ex.getMessage());
        String fileError = "The selected image is too large, please select another image";
        model.addAttribute("fileError", fileError);

        return "ErrorPage";
    }
}
