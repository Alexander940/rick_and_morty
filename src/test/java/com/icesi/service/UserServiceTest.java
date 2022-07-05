package com.icesi.service;

import com.icesi.exceptions.CouldNotCreateUserException;
import com.icesi.exceptions.WeakPasswordException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    private UserService userService;

    @Before
    public void setUp() throws Exception {
        userService = new UserService();
    }

    @Test(expected = WeakPasswordException.class)
    public void throws_an_exception_when_the_password_contains_lees_than_8_characters() throws WeakPasswordException, CouldNotCreateUserException {
        UserService.createUser("someone", "someone", "someone", "asb@gmail","asbr1");
    }

    @Test(expected = WeakPasswordException.class)
    public void throws_an_exception_when_the_password_does_not_contains_letters() throws WeakPasswordException, CouldNotCreateUserException {
        UserService.createUser("someone", "someone", "someone", "asb@gmail","12345");
    }

    @Test(expected = WeakPasswordException.class)
    public void throws_an_exception_when_the_password_does_not_contains_numbers() throws WeakPasswordException, CouldNotCreateUserException {
        UserService.createUser("someone", "someone", "someone", "asb@gmail","asbrf");
    }
}