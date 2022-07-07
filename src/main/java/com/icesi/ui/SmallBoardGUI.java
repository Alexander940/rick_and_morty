package com.icesi.ui;

import com.icesi.model.Game;
import com.icesi.util.ImageUtil;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SmallBoardGUI extends Stage implements BoardGUI {

    private final Image SEED = ImageUtil.loadImage("src/main/resources/img/seed.jpg");
    private GridPane gridPane;
    private Label[] labels = new Label[12];
    private Label timeLabel, nameTurnLabel, resultDiceLabel;
    private Button rollDiceBtn, moveAlongBtn, moveBackBtn;

    public SmallBoardGUI() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SmallBoardGUI.fxml"));
            Parent root = loader.load();

            gridPane = (GridPane) loader.getNamespace().get("gridPane");
            labels[0] = (Label) loader.getNamespace().get("label1");
            labels[1] = (Label) loader.getNamespace().get("label2");
            labels[2] = (Label) loader.getNamespace().get("label3");
            labels[3] = (Label) loader.getNamespace().get("label4");
            labels[4] = (Label) loader.getNamespace().get("label5");
            labels[5] = (Label) loader.getNamespace().get("label6");
            labels[6] = (Label) loader.getNamespace().get("label7");
            labels[7] = (Label) loader.getNamespace().get("label8");
            labels[8] = (Label) loader.getNamespace().get("label9");
            labels[9] = (Label) loader.getNamespace().get("label10");
            labels[10] = (Label) loader.getNamespace().get("label11");
            labels[11] = (Label) loader.getNamespace().get("label12");
            timeLabel = (Label) loader.getNamespace().get("timeLabel");
            nameTurnLabel = (Label) loader.getNamespace().get("nameTurnLabel");
            resultDiceLabel = (Label) loader.getNamespace().get("resultDiceLabel");
            rollDiceBtn = (Button) loader.getNamespace().get("rollDiceBtn");
            moveAlongBtn = (Button) loader.getNamespace().get("moveAlongBtn");
            moveBackBtn = (Button) loader.getNamespace().get("moveBackBtn");

            this.setResizable(false);

            Scene scene = new Scene(root, 500,200);
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
        nameTurnLabel.setText("Rick (" + " " + ") turns");

        rollDiceBtn.setOnAction(event -> {
            int resultDice = Game.getInstance().getBoard().rollDice();

            resultDiceLabel.setText(String.valueOf(resultDice));

            resultDiceLabel.setVisible(true);

            moveAlongBtn.setVisible(true);
            moveBackBtn.setVisible(true);

            nameTurnLabel.setVisible(false);
            rollDiceBtn.setVisible(false);
        });

        moveAlongBtn.setOnAction(event -> {

        });

        moveBackBtn.setOnAction(event -> {

        });
    }

    @Override
    public void updateTimeLabel(int seconds) {
        if(seconds < 60){
            if(seconds < 10){
                timeLabel.setText("0" + seconds);
            } else {
                timeLabel.setText(String.valueOf(seconds));
            }
        } else {
            int minutes = seconds/60;
            seconds -= (minutes*60);
            if(seconds < 10){
                timeLabel.setText(minutes + " : " + "0" + seconds);
            } else {
                timeLabel.setText(minutes + " : " + minutes);
            }
        }
    }

    @Override
    public void updateBoardLabel(String character, int position) {
        labels[position-1].setText(character);
    }

    @Override
    public void updateBoardLabel(int position) {
        labels[position-1].setText("");
        labels[position-1].setGraphic(new ImageView(SEED));
    }
}
