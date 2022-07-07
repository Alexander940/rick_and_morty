package com.icesi.util;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;

public class ImageUtil {

    /**
     * This method load an image into an image view
     * @param iv This is the image view
     * @param path This is the path of the image
     */
    public static Image loadImage(String path){
        try{
            File file = new File(path);
            FileInputStream fileInputStream = new FileInputStream(file);
            Image image = new Image(fileInputStream);
            return image;
        } catch (Exception exception){
            exception.printStackTrace();
            return null;
        }
    }
}
