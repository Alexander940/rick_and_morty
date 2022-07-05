package com.icesi.service;

import com.icesi.exceptions.CouldNotCreateUserException;
import com.icesi.exceptions.ExistsNicknameException;
import com.icesi.exceptions.UserNonExistentException;
import com.icesi.exceptions.WeakPasswordException;
import com.icesi.model.User;
import com.icesi.dao.UserDAO;
import com.icesi.util.ArrayUtil;
import com.icesi.util.PasswordUtil;

public class UserService {

    /**
     * This method creates a user and throw the information to layer DAO
     * @param name
     * @param lastname
     * @param nickname
     * @param email
     * @param password
     * @throws WeakPasswordException This is throw when the password is weak
     * @throws CouldNotCreateUserException This is throw when the user can't add to the database
     */
    public static void createUser(String name, String lastname, String nickname, String email, String password) throws WeakPasswordException, CouldNotCreateUserException {
        if(PasswordUtil.assessPassword(password)){
            User user = new User(name, lastname, nickname, email, password);
            UserDAO.createUser(user);
        } else {
            throw new WeakPasswordException();
        }
    }

    /**
     * This method find a user with his nickname
     * @param nickname
     * @return
     * @throws UserNonExistentException This is throw when the user can't be found in the database
     */
    public static User findUser(String nickname) throws UserNonExistentException {
        String [] userData = UserDAO.findUser(nickname);

        if(ArrayUtil.isEmpty(userData)){
            throw new UserNonExistentException();
        }

        return new User(Integer.parseInt(userData[0]), userData[1], userData[2], userData[3], userData[4], userData[5]);
    }

    /**
     * This method find a user for it know if the user exists
     * @param nickname
     * @throws ExistsNicknameException This is throw when the user is found
     */
    public static void compareNickname(String nickname) throws ExistsNicknameException{
        String [] userData = UserDAO.findUser(nickname);

        if(!ArrayUtil.isEmpty(userData)){
            throw new ExistsNicknameException();
        }
    }
}
