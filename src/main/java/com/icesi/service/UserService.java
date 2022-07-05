package com.icesi.service;

import com.icesi.exceptions.CouldNotCreateUserException;
import com.icesi.exceptions.ExistsNicknameException;
import com.icesi.exceptions.WeakPasswordException;
import com.icesi.model.User;
import com.icesi.dao.UserDAO;

public class UserService {

    public static void createUser(String name, String lastname, String nickname, String email, String password) throws WeakPasswordException, CouldNotCreateUserException {
        if(Password.verifyPassword(password)){
            User user = new User(name, lastname, nickname, email, password);
            UserDAO.createUser(user);
        } else {
            throw new WeakPasswordException();
        }
    }

    public static User findUser(String nickname){
        String [] userData = UserDAO.findUser(nickname);

        return new User(Integer.parseInt(userData[0]), userData[1], userData[2], userData[3], userData[4], userData[5]);
    }

    public static void compareNickname(String nickname) throws ExistsNicknameException{
        String [] userData = UserDAO.findUser(nickname);

        if(!isEmpty(userData)){
            throw new ExistsNicknameException();
        }
    }

    private static boolean isEmpty(String [] array){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == null){
                return true;
            }
        }

        return false;
    }
}
