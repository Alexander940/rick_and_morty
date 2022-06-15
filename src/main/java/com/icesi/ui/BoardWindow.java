package com.icesi.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author alexanderecheverry
 * @version 1.0
 */
public class BoardWindow extends Stage {

    public BoardWindow() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BoardWindow.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root, 600,400);
            setScene(scene);

            init();
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

    private void init() {

    }
}
