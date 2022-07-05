package com.icesi.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainWindow extends Stage {

    ImageView imageView;
    Button signUpBtn, logInBtn;
    AnchorPane panel;

    public MainWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainWindow.fxml"));
            Parent root = loader.load();

            imageView = (ImageView) loader.getNamespace().get("imageView");
            signUpBtn = (Button) loader.getNamespace().get("signUpBtn");
            logInBtn = (Button) loader.getNamespace().get("logInBtn");
            panel = (AnchorPane) loader.getNamespace().get("panel");

            Scene scene = new Scene(root, 250,250);
            setScene(scene);

            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method execute the actions of fxml components
     */
    private void init() {
        loadImage(imageView, "src/main/resources/img/image_menu_main.png");

        panel.getStylesheets().clear();
        panel.getStylesheets().add("/styles/style1.css");

        logInBtn.setOnAction(event -> {
            LoginWindow loginWindow = new LoginWindow();
            loginWindow.show();

            this.close();
        });

        signUpBtn.setOnAction(event -> {
            SignUpWindow signUpWindow = new SignUpWindow();
            signUpWindow.show();
        });


    }

    /**
     * This method load an image into an image view
     * @param iv This is the image view
     * @param path This is the path of the image
     */
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
