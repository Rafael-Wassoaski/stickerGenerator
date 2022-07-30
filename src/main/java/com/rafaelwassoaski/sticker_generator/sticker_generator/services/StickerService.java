package com.rafaelwassoaski.sticker_generator.sticker_generator.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.rafaelwassoaski.sticker_generator.sticker_generator.entity.Sticker;

@Service
public class StickerService {
    public String generateSticker(Sticker sticker){
        try {
            return sticker.generateSticker();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
