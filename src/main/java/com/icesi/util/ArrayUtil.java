package com.icesi.util;

/**
 * This class contains utilities for an array
 */
public abstract class ArrayUtil {

    /**
     * This class assess if an array contains any value
     * @param array the array to assess
     * @return true if the array doesn't contain any value or false if the array contains values
     */
    public static boolean isEmpty(String[] array){
        for (String data :
                array) {
            if(data != null) return false;
        }

        return true;
    }
}
