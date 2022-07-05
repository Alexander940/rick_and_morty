package com.icesi.ui;

import com.icesi.model.Game;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class OptionsGameWindow extends Stage {

    Label hiLabel;

    public OptionsGameWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/OptionsGameWindow.fxml"));
            Parent root = loader.load();

            hiLabel = (Label) loader.getNamespace().get("hiLabel");

            Scene scene = new Scene(root, 250, 250);
            setScene(scene);

            init();
        } catch (IOException exception) {

        }
    }

    /**
     * this method execute the actions of fxml components
     */
    private void init() {
        hiLabel.setText("Hi " + Game.getInstance().getPrincipalPlayer().getName());
    }
}
