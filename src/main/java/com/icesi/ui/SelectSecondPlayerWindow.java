package com.icesi.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SelectSecondPlayerWindow extends Stage {

    public SelectSecondPlayerWindow() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SelectSecondPlayerWindow.fxml"));
            Parent root = loader.load();

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
