package com.rafaelwassoaski.sticker_generator.sticker_generator.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;

public class StickerGenerator {

    public String generateSticker(InputStream inputStream, String bottomMsg) throws IOException{
        
        BufferedImage originalImage = ImageIO.read(inputStream);

        int originalImageWidth = originalImage.getWidth();
        int originalImageHeight = originalImage.getHeight();
        int newImageHeight = originalImageHeight + 50;

        BufferedImage newImage = new BufferedImage(originalImageWidth, newImageHeight, BufferedImage.TRANSLUCENT);
        Graphics2D newImageGraphics = (Graphics2D) newImage.getGraphics();
        newImageGraphics.drawImage(originalImage, 0, 0, null);

        Font imageTextFont = new Font(Font.SERIF, Font.BOLD, 52);
        newImageGraphics.setFont(imageTextFont);
        newImageGraphics.setColor(Color.YELLOW);
        newImageGraphics.drawString(bottomMsg, originalImageWidth / 2 - ((bottomMsg.length() / 2) * (52/2)), newImageHeight - 11);

        String sanitizedFileName = "src/main/resources/" + sanitizeFileName(bottomMsg) + ".png" ;
        
        ImageIO.write(newImage, "png", new File(sanitizedFileName));

        return sanitizedFileName;
    }


    private String sanitizeFileName(String stickerName){
        String spaceSanitizedFileName =  stickerName.replaceAll(" ", "_");
        String dashSanitizedFileName =  spaceSanitizedFileName.replaceAll("/", "_");
        String colonSanitizedFileName =  dashSanitizedFileName.replaceAll(":", "_");

        return colonSanitizedFileName;
    }
}
