package com.icesi.ui;

import com.icesi.service.Alert;
import com.icesi.model.Game;
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
public class GameWindow extends Stage {

    private ImageView imageView;
    private Button startGameBtn;
    private Label hiLabel;
    private AnchorPane anchorPane;

    public GameWindow() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GameWindow.fxml"));
            Parent root = loader.load();

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
        loadImage(imageView, "src/main/resources/img/image_menu_main.png");
        hiLabel.setTextAlignment(TextAlignment.CENTER);
        hiLabel.setText("Hello, " + Game.getInstance().getPrincipalPlayer().getName());

        startGameBtn.setOnAction(e -> {
            if(Game.getInstance().getPrincipalPlayer() != null) {
                OptionsGameWindow optionsGameWindow = new OptionsGameWindow();
                optionsGameWindow.show();
            } else {
                Alert.errorAlert("Wrong", "You should login before to init a game", "");
            }
        });
    }

    /**
     * This method load an image into an image view
     * @param iv This is the image view
     * @param path This is the path of the image
     */
    private void loadImage(ImageView iv, String path){
        try{
            File file = new File(path);
            FileInputStream fileInputStream = new FileInputStream(file);
            Image image = new Image(fileInputStream);
            iv.setImage(image);
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
