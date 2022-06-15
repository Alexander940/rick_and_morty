package com.icesi.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDB {

    public static Connection connection;

    public static Connection get_connection(){

        if(connection == null){
            try{
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rick_and_morty", "root", "Thqpw214*sa");
                System.out.println("Successful connection");
            } catch (SQLException exception){
                exception.printStackTrace();
            }
        }

        return connection;
    }
}
