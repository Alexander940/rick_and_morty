package com.icesi.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;


/**
 * @author alexanderecheverry
 * @version 1.0
 */
public class MainWindow extends Stage {

    private ImageView imageView;
    private Button startGameBtn;

    public MainWindow() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainWindow.fxml"));
            Parent root = loader.load();

            imageView = (ImageView) loader.getNamespace().get("imageView");
            startGameBtn = (Button) loader.getNamespace().get("startGameBtn");

            Scene scene = new Scene(root, 600,400);
            setScene(scene);

            init();
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

    /**
     * this method execute the actions of fxml components
     */
    private void init() {
        loadImage(imageView, "src/main/resources/img/image_menu_main.png");

        startGameBtn.setOnAction(e -> {

        });
    }

    private void loadImage(ImageView iv, String path){
        try{
            File file = new File(path);
            FileInputStream fileInputStream = new FileInputStream(file);
            Image image = new Image(fileInputStream);
            iv.setImage(image);
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
