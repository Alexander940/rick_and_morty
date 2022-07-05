package com.icesi.connection;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConnectorDBTest {

    @Test
    public void generate_the_connection_to_database() {
        ConnectorDB.get_connection();

        assertNotNull(ConnectorDB.connection);
    }
}