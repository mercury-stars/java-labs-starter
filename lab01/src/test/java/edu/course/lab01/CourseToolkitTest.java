package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseToolkitTest {

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }

    @Test
    void returnsTrueForZero() {
        boolean result = CourseToolkit.isEven(0);

        assertTrue(result);
    }

    @Test 
    void returnsTrueForNegativeEvenNumber() {
        boolean result = CourseToolkit.isEven(-8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForNumberUnderTwo() {
        boolean result = CourseToolkit.isPrime(1);

        assertFalse(result);
    }

    @Test
    void returnsFalseForNonPrime() {
        boolean result = CourseToolkit.isPrime(12);

        assertFalse(result);
    }

    @Test 
    void returnsTrueForTwo() {
        boolean result = CourseToolkit.isPrime(2);

        assertTrue(result);
    }

    @Test
    void returnsFalseForSquare() {
        boolean result = CourseToolkit.isPrime(25);

        assertFalse(result);
    }

    @Test
    void returnsTrueForPalindrome() {
        boolean result = CourseToolkit.isPalindrome("radar");

        assertTrue(result);
    }

    @Test
    void returnsFalseForNonPalindrome() {
        boolean result = CourseToolkit.isPalindrome("red");

        assertFalse(result);
    }

    @Test
    void returnsTrueForPalindrome2() {
        boolean result = CourseToolkit.isPalindrome("1221");

        assertTrue(result);
    }

    @Test
    void returnsAverageForPositive() {
        int[] values = {2, 4, 6};
        assertEquals(4.0, CourseToolkit.average(values), 0.0001);
    }

    @Test
    void returnsAverageForNegative() {
        int[] values = {-2, -4, -6};
        assertEquals(-4.0, CourseToolkit.average(values), 0.0001);
        }

    @Test 
    void returnsExceptionForNull() {
        assertThrows(IllegalArgumentException.class,
                () -> CourseToolkit.average(null));
    }

}
