package com.icesi.service;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author alexanderecheverry
 * @version 1.0
 * This class contains utilities for password
 */
public abstract class Password {

    private final String CHARACTERS = "+*/?-_´´}{][''$%<>";

    public enum SecurityLevel{
        WEAK, MEDIUM, STRONG
    }

    /**
     * This method verify if a password is strong
     * @param password this is the password to verify
     * @return true, if the password is strong and false, if the password is weak
     */
    public static boolean verifyPassword(String password){
        return password.length() > 8 && password.matches("[a-zA-Z0-9]+");
    }

    /**
     * This method generates a random password
     * @return A string with the password
     */
    public static String generatePassword(){
        return RandomStringUtils.randomAlphanumeric(20);
    }
}
