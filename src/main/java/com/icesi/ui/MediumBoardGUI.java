package com.icesi.ui;

import com.icesi.model.Game;
import com.icesi.util.ImageUtil;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class MediumBoardGUI extends Stage implements BoardGUI{

    private final Image SEED = ImageUtil.loadImage("src/main/resources/img/seed.jpg");
    private final Label[] labels = new Label[20];
    private Label timeLabel, nameTurnLabel, resultDiceLabel;
    private Button rollDiceBtn, moveForwardBtn, moveBackBtn;
    private String nameTurn;

    public MediumBoardGUI() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MediumBoardGUI.fxml"));
            Parent root = loader.load();

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
            labels[12] = (Label) loader.getNamespace().get("label13");
            labels[13] = (Label) loader.getNamespace().get("label14");
            labels[14] = (Label) loader.getNamespace().get("label15");
            labels[15] = (Label) loader.getNamespace().get("label16");
            labels[16] = (Label) loader.getNamespace().get("label17");
            labels[17] = (Label) loader.getNamespace().get("label18");
            labels[18] = (Label) loader.getNamespace().get("label19");
            labels[19] = (Label) loader.getNamespace().get("label20");
            timeLabel = (Label) loader.getNamespace().get("timeLabel");
            nameTurnLabel = (Label) loader.getNamespace().get("nameTurnLabel");
            resultDiceLabel = (Label) loader.getNamespace().get("resultDiceLabel");
            rollDiceBtn = (Button) loader.getNamespace().get("rollDiceBtn");
            moveForwardBtn = (Button) loader.getNamespace().get("moveForwardBtn");
            moveBackBtn = (Button) loader.getNamespace().get("moveBackBtn");

            this.setResizable(false);

            Scene scene = new Scene(root, 600, 300);
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
        nameTurn = "Rick";
        nameTurnLabel.setText(nameTurn + " (" + Game.getInstance().getFirstPlayer().getName() + ") turns");

        rollDiceBtn.setOnAction(event -> {
            int resultDice = Game.getInstance().getBoard().rollDice();

            resultDiceLabel.setText(String.valueOf(resultDice));

            resultDiceLabel.setVisible(true);

            moveForwardBtn.setVisible(true);
            moveBackBtn.setVisible(true);

            nameTurnLabel.setVisible(false);
            rollDiceBtn.setVisible(false);
        });

        moveForwardBtn.setOnAction(event -> {
            if(nameTurn.equalsIgnoreCase("Rick")){
                Game.getInstance().movePlayer(Game.Turn.RICK, Integer.parseInt(resultDiceLabel.getText()), this, Game.SideToMove.FORWARD);
                nameTurn = "Morty";
            } else {
                Game.getInstance().movePlayer(Game.Turn.MORTY, Integer.parseInt(resultDiceLabel.getText()), this, Game.SideToMove.FORWARD);
                nameTurn = "Rick";
            }
            rollDiceState();
        });

        moveBackBtn.setOnAction(event -> {
            if(nameTurn.equalsIgnoreCase("Rick")){
                Game.getInstance().movePlayer(Game.Turn.RICK, Integer.parseInt(resultDiceLabel.getText()), this, Game.SideToMove.BACK);
                nameTurn = "Morty";
            } else {
                Game.getInstance().movePlayer(Game.Turn.MORTY, Integer.parseInt(resultDiceLabel.getText()), this, Game.SideToMove.BACK);
                nameTurn = "Rick";
            }
            rollDiceState();
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
                timeLabel.setText(minutes + " : " + seconds);
            }
        }
    }

    @Override
    public void updateBoardLabel(String character, int position) {
        labels[position-1].setText(character);
    }

    @Override
    public void addImageLabel(int position) {
        labels[position-1].setText("");
        labels[position-1].setGraphic(new ImageView(SEED));
    }

    @Override
    public void removeImageLabel(String character, int position) {
        labels[position-1].setGraphic(null);
        updateBoardLabel(character,position);
    }

    /**
     * This method change the visible of move buttons and labels to false, and change the
     * visible of roll dice button and label visible to true
     */
    private void rollDiceState(){
        moveForwardBtn.setVisible(false);
        moveBackBtn.setVisible(false);
        rollDiceBtn.setVisible(true);
        nameTurnLabel.setVisible(true);
        if(nameTurn.equalsIgnoreCase("Rick")){
            nameTurnLabel.setText(nameTurn + " (" + Game.getInstance().getFirstPlayer().getName() + ") turns");
        } else {
            nameTurnLabel.setText(nameTurn + " (" + Game.getInstance().getSecondPlayer().getName() + ") turns");
        }
    }
}
