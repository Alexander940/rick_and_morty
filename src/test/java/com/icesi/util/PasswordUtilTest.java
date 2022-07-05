package com.icesi.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordUtilTest {

    @Test
    public void generate_the_password() {
        String password = PasswordUtil.generatePassword();

        assertNotNull(password);
    }
}