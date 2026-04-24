package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {"level", "топот", "шалаш"})
    void isPalindrome(String word) {
        StringUtils utils = new StringUtils();
        assertTrue(utils.isPalindrome(word));
    }

}