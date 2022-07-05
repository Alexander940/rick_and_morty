package com.icesi.dao;

import com.icesi.dao.UserDAO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDAOTest {

    @Before
    public void setUp() throws Exception {
        UserDAO userDAO = new UserDAO();
    }

    @Test
    public void find_a_user() {
        String [] user = UserDAO.findUser("Alexander");

        assertNotNull(user[2]);
    }
}