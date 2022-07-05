package com.icesi.service;

import com.icesi.service.Password;
import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordTest {

    @Test
    public void generate_the_password() {
        String password = Password.generatePassword();

        assertNotNull(password);
    }
}