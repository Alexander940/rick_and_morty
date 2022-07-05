package com.icesi.ui;

import com.icesi.model.Game;
import com.icesi.model.User;
import com.icesi.service.UserService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import com.icesi.service.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author alexanderecheverry
 * @version 1.0
 * This class controls the login window
 */
public class LoginWindow extends Stage {

    TextField nicknameTF;
    PasswordField passwordPF;
    Button loginBtn;

    public LoginWindow() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LoginWindow.fxml"));
            Parent root = loader.load();

            nicknameTF = (TextField) loader.getNamespace().get("nicknameTF");
            passwordPF = (PasswordField) loader.getNamespace().get("passwordPF");
            loginBtn = (Button) loader.getNamespace().get("loginBtn");

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
        loginBtn.setOnAction(event -> {
            User loginUser = UserService.findUser(nicknameTF.getText());

            if(Game.getInstance().getPrincipalPlayer() == null && loginUser.getPassword().equals(passwordPF.getText())){
                Game.getInstance().setPrincipalPlayer(loginUser);
                GameWindow gameWindow = new GameWindow();
                gameWindow.show();
                this.close();
            } else if (Game.getInstance().getPrincipalPlayer() != null && Game.getInstance().getSecondPlayer() == null && loginUser.getPassword().equals(passwordPF.getText())){
                Game.getInstance().setSecondPlayer(loginUser);
            } else {
                Alert.errorAlert("Wrong","The both player are login","");
            }
        });
    }
}
