package edu.course.lab02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProjectTaskTest {

    @Test
    void createValidTask() {
        ProjectTask task = new ProjectTask("123", "red", 5);
        assertEquals("123", task.getId());
        assertEquals(TaskStatus.NEW, task.getStatus());
        assertFalse(task.isCompleted());
    }

    @Test
    void ExcpetionForEmptyId() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("", "Title", 5));
    }

    @Test 
    void shouldIncreaseHours() {
        ProjectTask task = new ProjectTask("123", "red", 5);
        task.increaseEstimatedHours(3);
        assertEquals(8, task.getEstimatedHours());
    }

    @Test
    void changeStatus() {
        ProjectTask task = new ProjectTask("123", "red", 5);
        task.changeStatus(TaskStatus.DONE);
        assertTrue(task.isCompleted());
    }
    
}
