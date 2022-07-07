package com.icesi.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectSecondPlayerGUI extends Stage {

    public SelectSecondPlayerGUI() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SelectSecondPlayerGUI.fxml"));
            Parent root = loader.load();

            this.setResizable(false);

            Scene scene = new Scene(root, 600,400);
            setScene(scene);

            init();
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    /**
     * this method execute the actions of fxml components
     */
    private void init() {

    }
}
