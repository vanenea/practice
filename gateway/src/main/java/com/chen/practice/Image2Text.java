package com.chen.practice;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image2Text {

    public static void main(String[] args) {
        System.out.println("fd");
        toText("1.jpg");
    }

    public static void toText(String path){
        final String base = "@#$%o*;.";
        try{
            final BufferedImage image = ImageIO.read(new File(path));
            for(int y=0; y< image.getHeight(); y+=8){
                for (int x = 0; x< image.getWidth(); x+=4){
                    final int pixel = image.getRGB(x, y);
                    final int r = (pixel & 0xff0000) >> 16 , g = (pixel & 0xff00) >>8, b=pixel & 0xff;
                    final float gray = 0.299f * r + 0.578f * g + 0.114f * b;
                    final int index = Math.round(gray * (base.length() + 1) / 255);
                    System.out.print(index >= base.length() ? "" :String.valueOf(base.charAt(index)));
                }
                System.out.println();
            }
        }catch (final IOException e){
            e.printStackTrace();
        }
    }
}
