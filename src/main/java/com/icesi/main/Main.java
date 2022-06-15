package com.icesi.main;

import com.icesi.connection.ConnectorDB;
import javafx.application.Application;
import javafx.stage.Stage;
import com.icesi.ui.MainWindow;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author alexanderecheverry
 * @version 1.0
 */
public class Main extends Application {

    public static void main(String[] args) {
        try(Connection connection = ConnectorDB.get_connection()){

        }catch (SQLException exception){
            exception.printStackTrace();
        }

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainWindow mainWindow = new MainWindow();
        mainWindow.show();
    }
}
