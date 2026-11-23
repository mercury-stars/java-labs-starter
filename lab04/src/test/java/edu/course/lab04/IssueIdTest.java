package edu.course.lab04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IssueIdTest {

    @Test
    void equalForSameFields() {
        IssueId a = new IssueId("LAB", 42);
        IssueId b = new IssueId("LAB", 42);
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    void notEqualForDifferentFields() {
        assertNotEquals(new IssueId("LAB", 42), new IssueId("LAB", 43));
        assertNotEquals(new IssueId("LAB", 42), new IssueId("PRJ", 42));
    }

    @Test
    void nullAndForeignTypeReturnFalse() {
        IssueId a = new IssueId("LAB", 42);
        assertFalse(a.equals(null));
        assertFalse(a.equals("LAB 42"));
        assertFalse(a.equals(42));
    }
}
