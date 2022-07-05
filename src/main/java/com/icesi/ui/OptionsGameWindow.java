package com.icesi.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class OptionsGameWindow extends Stage {

    Button fastGameBtn, mediumGameBtn, longGameBtn;

    public OptionsGameWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/OptionsGameWindow"));
            Parent root = loader.load();

            fastGameBtn = (Button) loader.getNamespace().get("fastGameBtn");
            mediumGameBtn = (Button) loader.getNamespace().get("mediumGameBtn");
            longGameBtn = (Button) loader.getNamespace().get("longGameBtn");

            Scene scene = new Scene(root, 600,400);
            setScene(scene);

            init();
        } catch (IOException exception){
            exception.printStackTrace();
        }
    }

    /**
     * this method execute the actions of fxml components
     */
    private void init() {

    }
}
