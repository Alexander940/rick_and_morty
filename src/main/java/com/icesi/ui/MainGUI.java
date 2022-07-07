package com.icesi.ui;

import com.icesi.util.ImageUtil;
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

public class MainGUI extends Stage {

    ImageView imageView;
    Button signUpBtn, logInBtn;
    AnchorPane panel;

    public MainGUI() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainGUI.fxml"));
            Parent root = loader.load();

            this.setResizable(false);

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
        imageView.setImage(ImageUtil.loadImage("src/main/resources/img/image_menu_main.png"));

        panel.getStylesheets().clear();
        panel.getStylesheets().add("/styles/MainWindow.css");

        logInBtn.setOnAction(event -> {
            LoginGUI loginWindow = new LoginGUI();
            loginWindow.show();

            this.close();
        });

        signUpBtn.setOnAction(event -> {
            SignUpGUI signUpWindow = new SignUpGUI();
            signUpWindow.show();
        });


    }
}
