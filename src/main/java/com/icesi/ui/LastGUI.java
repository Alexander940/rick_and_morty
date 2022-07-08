package com.icesi.ui;

import com.icesi.model.Game;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class LastGUI extends Stage {

    private Label winnerLabel, pointsLabel;
    private Button getOutBtn;

    public LastGUI() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LastGUI.fxml"));
            Parent root = loader.load();

            winnerLabel = (Label) loader.getNamespace().get("winnerLabel");
            pointsLabel = (Label) loader.getNamespace().get("pointsLabel");
            getOutBtn = (Button) loader.getNamespace().get("getOutBtn");

            Scene scene = new Scene(root, 250, 250);
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
        String winner = "";
        int score = 0;
        if(Game.getInstance().getFirstPlayer().isWinner()){
            winner = Game.getInstance().getFirstPlayer().getName();
            score = Game.getInstance().getFirstPlayer().getPoints();
        } else if(Game.getInstance().getSecondPlayer().isWinner()){
            winner = Game.getInstance().getSecondPlayer().getName();
            score = Game.getInstance().getSecondPlayer().getPoints();
        }
        winnerLabel.setText("The winner is " + winner);
        pointsLabel.setText("Your score is " + score);

        getOutBtn.setOnAction(event -> {
            System.exit(0);
        });
    }
}
