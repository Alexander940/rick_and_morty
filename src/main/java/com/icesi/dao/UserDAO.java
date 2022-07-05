package com.icesi.dao;

import com.icesi.connection.ConnectorDB;
import com.icesi.exceptions.CouldNotCreateUserException;
import com.icesi.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public static void createUser(User user) throws CouldNotCreateUserException{
        try(Connection connection = ConnectorDB.get_connection()){
            PreparedStatement ps;

            String query = "INSERT INTO `users` (`name`, `lastname`, `nickname`, `email`, `password`, `date_sign_up`) VALUES (?,?,?,?,?,CURRENT_TIMESTAMP)";
            ps = connection.prepareStatement(query);

            ps.setString(1, user.getName());
            ps.setString(2,user.getLastname());
            ps.setString(3,user.getNickname());
            ps.setString(4,user.getEmail());
            ps.setString(5,user.getPassword());

            ps.executeUpdate();
        } catch (SQLException exception){
            exception.printStackTrace();
            throw new CouldNotCreateUserException();
        }
    }

    public static String [] findUser(String nickname){
        try(Connection connection = ConnectorDB.get_connection()){
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT * FROM users WHERE nickname = ?";
            ps = connection.prepareStatement(query);

            ps.setString(1,nickname);

            rs = ps.executeQuery();

            String [] userData = new String[6];

            while(rs.next()){
                userData[0] = rs.getString("id");
                userData[1] = rs.getString("name");
                userData[2] = rs.getString("lastname");
                userData[3] = rs.getString("nickname");
                userData[4] = rs.getString("email");
                userData[5] = rs.getString("password");
            }

            return userData;
        } catch (SQLException exception){
            exception.printStackTrace();
            return null;
        }
    }
}
