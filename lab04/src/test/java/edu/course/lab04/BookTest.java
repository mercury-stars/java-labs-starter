package edu.course.lab04;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void valueFoundByLogicallyEqualBook() {
        Book key1 = new Book("333", "red");
        Book key2 = new Book("333", "blue");

        Map<Book, String> shelf = new HashMap<>();
        shelf.put(key1, "на полке");

        assertEquals("на полке", shelf.get(key2));
    }

    @Test
    void booksWithDifferentIsbnAreNotEqual() {
        Book a = new Book("111", "A");
        Book b = new Book("222", "B");
        assertNotEquals(a, b);
        assertNotEquals(a.hashCode(), b.hashCode());
    }

    @Test
    void equalsContractBasics() {
        Book a = new Book("111", "A");
        assertTrue(a.equals(a));
        assertFalse(a.equals(null));
        assertFalse(a.equals("111"));
    }
}