package com.icesi.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayUtilTest {

    @Test
    public void when_the_array_is_empty_return_true() {
        String [] array = {null, null, null};

        assertTrue(ArrayUtil.isEmpty(array));
    }

    @Test
    public void when_the_array_is_not_empty_return_false() {
        String [] array = {null, "some", null};

        assertFalse(ArrayUtil.isEmpty(array));
    }
}