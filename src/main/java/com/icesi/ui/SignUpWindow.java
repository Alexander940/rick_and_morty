package com.icesi.ui;

import com.icesi.exceptions.CouldNotCreateUserException;
import com.icesi.exceptions.ExistsNicknameException;
import com.icesi.exceptions.WeakPasswordException;
import com.icesi.model.Game;
import com.icesi.service.Password;
import com.icesi.service.UserService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import com.icesi.service.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;

/**
 * @author alexanderecheverry 
 * @version 1.0
 * This class controls the fxml login window
 */
public class SignUpWindow extends Stage {

    private TextField nameTF, lastnameTF, emailTF, nicknameTF, passwordTF, confirmPasswordTF;
    private Button signupBtn, autoGeneratePasswordBtn;

    public SignUpWindow(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SignUpWindow.fxml"));
            Parent root = loader.load();

            nameTF = (TextField) loader.getNamespace().get("nameTF");
            lastnameTF = (TextField) loader.getNamespace().get("lastnameTF");
            emailTF = (TextField) loader.getNamespace().get("emailTF");
            nicknameTF = (TextField) loader.getNamespace().get("nicknameTF");
            passwordTF = (TextField) loader.getNamespace().get("passwordTF");
            confirmPasswordTF = (TextField) loader.getNamespace().get("confirmPasswordTF");
            signupBtn = (Button) loader.getNamespace().get("signupBtn");
            autoGeneratePasswordBtn = (Button) loader.getNamespace().get("autoGeneratePasswordBtn");

            Scene scene = new Scene(root,250,500);
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
        signupBtn.setOnAction(e -> {
            if(passwordTF.getText().equals(confirmPasswordTF.getText())){
                try {
                    UserService.compareNickname(nicknameTF.getText());
                    UserService.createUser(nameTF.getText(), lastnameTF.getText(), nicknameTF.getText(), emailTF.getText(), passwordTF.getText());
                    Alert.confirmationAlert("Successful operation", "Congratulations", "Now you can play");
                    Game.getInstance().setPrincipalPlayer(UserService.findUser(nicknameTF.getText()));
                    GameWindow gameWindow = new GameWindow();
                    gameWindow.show();
                    this.close();
                } catch (WeakPasswordException exception){
                    Alert.errorAlert("Wrong", "Weak password", "The password should contain letters, numbers and symbols");
                } catch (CouldNotCreateUserException exception){
                    Alert.errorAlert("Wrong", "Sorry", "An error happened, the user couldn't be create");
                } catch (ExistsNicknameException exception){
                    Alert.errorAlert("Wrong", "This nickname already exists", "");
                }
            } else {
                Alert.errorAlert("Wrong", "The passwords aren't equals", "");
            }
        });

        autoGeneratePasswordBtn.setOnAction(e -> {
            String password = Password.generatePassword();

            passwordTF.setText(password);
            confirmPasswordTF.setText(password);

        });
    }
}
