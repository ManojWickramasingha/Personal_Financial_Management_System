package edu.icet.pim.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageCompressor {

    public static byte[] compress(byte[] imageBytes) {
        try {

            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            BufferedImage originalImage = ImageIO.read(bais);


            int targetWidth = 300;
            int targetHeight = 300;
            BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);


            Graphics2D g = resizedImage.createGraphics();
            g.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
            g.dispose();


            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(resizedImage, "jpg", baos);
            baos.flush();
            byte[] compressedImage = baos.toByteArray();
            baos.close();

            return compressedImage;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

