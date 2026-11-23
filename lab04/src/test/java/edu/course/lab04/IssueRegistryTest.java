package edu.course.lab04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IssueRegistryTest {

    private final IssueRegistry registry = new IssueRegistry();

    @Test
    void logicallyEqualKeyFindsValue() {
        ProjectTask task = new ProjectTask("написать тесты", 5);
        registry.put(new IssueId("LAB", 1), task);

        ProjectTask found = registry.get(new IssueId("LAB", 1));

        assertSame(task, found);
    }

    @Test
    void putWithEqualKeyReplacesValue() {
        IssueId k1 = new IssueId("LAB", 1);
        IssueId k2 = new IssueId("LAB", 1);
        ProjectTask oldTask = new ProjectTask("old task", 2);
        ProjectTask newTask = new ProjectTask("new task", 8);

        registry.put(k1, oldTask);
        int sizeAfterFirst = registry.size();
        assertEquals(1, sizeAfterFirst);

        ProjectTask previous = registry.put(k2, newTask);

        assertSame(oldTask, previous);
        assertSame(newTask, registry.get(k1));
        assertEquals(sizeAfterFirst, registry.size());
        assertEquals(1, registry.size());
    }

    @Test
    void collisionDoesNotMergeEntries() {
        IssueId a = new IssueId("prj", 1) {
            @Override
            public int hashCode() { return 0; }
        };
        IssueId b = new IssueId("prj", 2) {
            @Override
            public int hashCode() { return 0; }
        };

        assertEquals(a.hashCode(), b.hashCode());
        assertNotEquals(a, b);

        ProjectTask taskA = new ProjectTask("task A", 1);
        ProjectTask taskB = new ProjectTask("task B", 2);

        registry.put(a, taskA);
        registry.put(b, taskB);

        assertEquals(2, registry.size());
        assertSame(taskA, registry.get(a));
        assertSame(taskB, registry.get(b));
    }

    @Test
    void registryHandlesMissingKeys() {
        IssueId missing = new IssueId("no", 99);

        assertNull(registry.get(missing));
        assertFalse(registry.contains(missing));
        assertEquals(0, registry.size());
    }

    @Test
    void removeAndContainsWork() {
        IssueId id = new IssueId("LAB", 7);
        ProjectTask task = new ProjectTask(" yдаляемая задача", 3);

        registry.put(id, task);
        assertTrue(registry.contains(id));

        ProjectTask removed = registry.remove(id);
        assertSame(task, removed);

        assertFalse(registry.contains(id));
        assertNull(registry.get(id));
        assertEquals(0, registry.size());
    }
}