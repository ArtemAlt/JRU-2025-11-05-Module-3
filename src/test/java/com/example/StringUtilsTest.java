package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {"level", "топот", "шалаш", "1223221"})
    void isPalindrome(String word) {
        StringUtils utils = new StringUtils();
        assertTrue(utils.isPalindrome(word));
    }

    static Stream<Arguments> isPalindrome() {
        return Stream.of(
                Arguments.of("level", true),
                Arguments.of("jdhd", false)
        );
    }

    @ParameterizedTest
    @MethodSource("isPalindrome")
    void isPalindrome1(String word, boolean expected) {
        StringUtils utils = new StringUtils();
        assertEquals(expected, utils.isPalindrome(word));
    }
}