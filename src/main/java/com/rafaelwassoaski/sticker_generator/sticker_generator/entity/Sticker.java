package com.rafaelwassoaski.sticker_generator.sticker_generator.entity;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.springframework.web.client.RestClientException;
import org.springframework.web.multipart.MultipartFile;
import com.rafaelwassoaski.sticker_generator.sticker_generator.util.StickerGenerator;

public class Sticker {
    private MultipartFile file;
    private String imageUrl;
    private String text;

    public Sticker() {}

    public Sticker(String imageUrl, String text) {
        this.imageUrl = imageUrl;
        this.text = text;
    }

    public Sticker(MultipartFile file, String text) {
        this.file = file;
        this.text = text;
    }

    public Sticker(MultipartFile file, String imageUrl, String text) {
        this(file, text);
    }

    public MultipartFile getFile() {
        return file;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    
    public String getText() {
        return text;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String generateSticker() throws MalformedURLException, IOException{
        InputStream iStream;

        if(getText() != null || getText().isEmpty()){
            throw new RestClientException("Campo de texto nao pode ser vazio");
        }

        if(!getImageUrl().isEmpty() && getFile().isEmpty()){
            iStream = new URL(getImageUrl()).openStream();
        }else{
            iStream = getFile().getInputStream();
        }

        StickerGenerator stickerGenerator = new StickerGenerator();

    
        return stickerGenerator.generateSticker(iStream, getText());
    }
}
