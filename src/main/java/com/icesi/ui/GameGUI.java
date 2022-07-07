package com.icesi.ui;

import com.icesi.util.AlertUtil;
import com.icesi.model.Game;
import com.icesi.util.ImageUtil;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;


/**
 * @author alexanderecheverry
 * @version 1.0
 */
public class GameGUI extends Stage {

    private ImageView imageView;
    private Button startGameBtn;
    private Label hiLabel;
    private AnchorPane anchorPane;

    public GameGUI() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GameGUI.fxml"));
            Parent root = loader.load();

            this.setResizable(false);

            imageView = (ImageView) loader.getNamespace().get("imageView");
            startGameBtn = (Button) loader.getNamespace().get("startGameBtn");
            hiLabel = (Label) loader.getNamespace().get("hiLabel");
            anchorPane = (AnchorPane) loader.getNamespace().get("anchorPane");

            Scene scene = new Scene(root, 250,250);
            setScene(scene);

            init();
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

    /**
     * this method execute the actions of fxml components
     */
    private void init() {
        imageView.setImage(ImageUtil.loadImage("src/main/resources/img/image_menu_main.png"));

        hiLabel.setTextAlignment(TextAlignment.CENTER);
        //hiLabel.setText("Hello, " + Game.getInstance().getFirstPlayer().getName());

        startGameBtn.setOnAction(e -> {
            LoginSecondPlayerGUI optionsGameWindow = new LoginSecondPlayerGUI();
            optionsGameWindow.show();
            this.close();
        });
    }
}
