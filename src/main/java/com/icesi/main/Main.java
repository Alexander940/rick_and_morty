package com.icesi.main;

import com.icesi.ui.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author alexanderecheverry
 * @version 1.0
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainWindow mainWindow = new MainWindow();
        mainWindow.show();
    }
}
