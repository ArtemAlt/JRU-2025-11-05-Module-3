package com.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Тестируем калькулятор")
class CalculatorTest {
    private Calculator calc;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Starting Calculator Test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finished Calculator Test");
    }

    @BeforeEach
    void setUp() {
        calc = new Calculator();
        System.out.println("Create new Calculator");
    }

    @AfterEach
    void tearDown() {
        calc = null;
        System.out.println("Tear down");
    }

    @Test
    @DisplayName("Сложение")
    @Order(1)
    void add() {
        int expectedResult = 3;
        int result = calc.add(1, 2);
        assertEquals(expectedResult, result);
        assertEquals(expectedResult, calc.getLastResult());
    }

    @Test
    @DisplayName("Вычитание")
    @Order(4)
    void subtract() {
        int expectedResult = -1;
        int result = calc.subtract(1, 2);
        assertEquals(expectedResult, result);
        assertEquals(expectedResult, calc.getLastResult());
    }

    @Test
    @Order(2)
    void multiply() {
        int expectedResult = 4;
        int result = calc.multiply(2, 2);
        assertEquals(expectedResult, result);
        assertEquals(expectedResult, calc.getLastResult());
    }

    @Test
    @Order(3)
    void divide() {
        int expectedResult = 1;
        int result = calc.divide(2, 2);
        assertEquals(expectedResult, result);
        assertEquals(expectedResult, calc.getLastResult());
    }

    @Test
    void divideByZero() {
        int expectedResult = 0;
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> calc.divide(5, 0));
        assertEquals("На ноль делить нельзя!", e.getMessage());
        assertEquals(expectedResult, calc.getLastResult());
    }

    @Test
    @Disabled("Fix tomorrow")
    void divideByNegative() {
        int expectedResult = -1;
        int divide = calc.divide(-2, -2);
        assertEquals(expectedResult, divide + 1);
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(-1, 5, 4),
                Arguments.of(-1, -2, -3),
                Arguments.of(1, 0, 1),
                Arguments.of(-1, 1, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    @DisplayName("Проверяем сложение всех аргументов")
    void fullAddTest(int a, int b, int expectedResult) {
        int result = calc.add(a, b);
        assertEquals(expectedResult, result);
    }

}