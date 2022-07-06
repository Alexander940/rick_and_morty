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

public class LoginSecondPlayerWindow extends Stage {

    TextField nicknameTf;
    PasswordField passwordPf;
    Button signUpBtn, logInBtn;

    public LoginSecondPlayerWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LoginSecondPlayerWindow.fxml"));
            Parent root = loader.load();

            this.setResizable(false);

            nicknameTf = (TextField) loader.getNamespace().get("nicknameTf");
            passwordPf = (PasswordField) loader.getNamespace().get("passwordPf");
            signUpBtn = (Button) loader.getNamespace().get("signUpBtn");
            logInBtn = (Button) loader.getNamespace().get("logInBtn");

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
        signUpBtn.setOnAction(event -> {
            SignUpWindow signUpWindow = new SignUpWindow();
            signUpWindow.show();
        });

        logInBtn.setOnAction(event -> {
            try {
                User loginUser = UserService.findUser(nicknameTf.getText());

                if(Game.getInstance().getSecondPlayer() == null && loginUser.getPassword().equals(passwordPf.getText())){
                    Game.getInstance().setSecondPlayer(loginUser);
                    this.close();
                } else {
                    AlertUtil.errorAlert("Wrong","The password aren't equals", "");
                }
            } catch (UserNonExistentException exception){
                AlertUtil.errorAlert("Wrong", "The user doesn't exists", "");
            }
        });
    }
}
