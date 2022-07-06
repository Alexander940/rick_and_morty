package com.icesi.ui;

import com.icesi.exceptions.UserNonExistentException;
import com.icesi.model.Game;
import com.icesi.model.User;
import com.icesi.util.AlertUtil;
import com.icesi.service.UserService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

            this.setResizable(false);

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
            try{
                User loginUser = UserService.findUser(nicknameTF.getText());

                if(Game.getInstance().getFirstPlayer() == null && loginUser.getPassword().equals(passwordPF.getText())){
                    Game.getInstance().setFirstPlayer(loginUser);
                    GameWindow gameWindow = new GameWindow();
                    gameWindow.show();
                    this.close();
                } else {
                    AlertUtil.errorAlert("Wrong","The password aren't equals", "");
                }
            } catch (UserNonExistentException exception){
                AlertUtil.errorAlert("Wrong", "The user doesn't exist", "");
            }
        });
    }
}
