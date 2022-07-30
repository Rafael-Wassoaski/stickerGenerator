package com.rafaelwassoaski.sticker_generator.sticker_generator.conntrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class HomeController {
    
    @GetMapping("/")
    public RedirectView redirectHomeToStickers(RedirectAttributes attributes){
        return new RedirectView("stickers");
    }
}
