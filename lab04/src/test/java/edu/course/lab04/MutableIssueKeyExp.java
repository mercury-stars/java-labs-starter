package edu.course.lab04;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MutableIssueKeyExp {

    @Test
    void mutatedKeyBecomesUnfindable() {
        Map<MutableIssueKey, String> map = new HashMap<>();
        MutableIssueKey key = new MutableIssueKey("LAB", 1);
        map.put(key, "значение");

        assertTrue(map.containsKey(key));

        key.setNumber(2);

        assertFalse(map.containsKey(key));

        assertNull(map.get(new MutableIssueKey("LAB", 1)));
        
        assertEquals(1, map.size());
    }
}
