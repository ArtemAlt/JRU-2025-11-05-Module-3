package com.example.util;

public class StringUtils {

    public boolean isPalindrome(String str) {
        return new StringBuilder(str).reverse().toString().equals(str);
    }
}
