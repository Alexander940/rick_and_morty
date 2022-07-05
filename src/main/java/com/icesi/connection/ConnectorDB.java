package com.icesi.connection;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author alexanderecheverry
 * @version 1.0
 * This class generates the connection to database
 */
public class ConnectorDB {

    public static Connection connection;

    private static BasicDataSource basicDataSource = new BasicDataSource();

    static {
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("Thqpw214*sa");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/rick_and_morty");
        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxIdle(10);
        basicDataSource.setMaxOpenPreparedStatements(100);
    }

    public static Connection get_connection(){
        /*if(connection == null){
            try {




                connection = basicDataSource.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }*/

        try {
            return basicDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        /*if(connection == null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");

                String unicode="useSSL=false&autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8";
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rick_and_morty?user=root&password=Thqpw214*sa");
            } catch (SQLException exception){
                exception.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;*/
    }
}
