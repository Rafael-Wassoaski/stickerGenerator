package com.rafaelwassoaski.sticker_generator.sticker_generator.exceptions;

public class TextToLargeException extends Exception{

    public TextToLargeException(){
        super("Sticker text is too long, limit text to 20 characters");
    }
    
}
