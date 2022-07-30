package com.rafaelwassoaski.sticker_generator.sticker_generator.conntrollers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.annotation.Resource;
import javax.sound.midi.Patch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.rafaelwassoaski.sticker_generator.sticker_generator.entity.Sticker;
import com.rafaelwassoaski.sticker_generator.sticker_generator.services.StickerService;

@Controller
@RequestMapping("")
public class StickerController {

    @Autowired
    private StickerService service;

    @GetMapping("")
    public String getStickerCreationHome(Model model) {
        Sticker stickerData = new Sticker();

        model.addAttribute("sticker", stickerData);
        return "Home";
    }

    @PostMapping("")
    public ResponseEntity<InputStreamResource> generateSticker(@ModelAttribute Sticker sticker) throws FileNotFoundException {
        String stickerPath = service.generateSticker(sticker);

        File file = new File(stickerPath);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
            .contentLength(file.length())
            .contentType(MediaType.IMAGE_PNG)
            .body(resource);
    }
}
