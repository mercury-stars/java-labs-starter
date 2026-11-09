package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskPrioritizerTest {
    
    private static ProjectTask createTask(String id, String title, int hours, TaskStatus status) {
        ProjectTask task = new ProjectTask(id, title, hours);
        task.changeStatus(status);
        return task;
    }

    private final ProjectTask low  = createTask("1", "low",  2, TaskStatus.DONE);
    private final ProjectTask high = createTask("2", "high", 10, TaskStatus.IN_PROGRESS);

    @Test
    void effortPolicyPrefersHigherEffort() {
        TaskPrioritizer t = new TaskPrioritizer(new EffortPriorityPolicy());
        assertSame(high, t.pickHigher(low, high));
    }

    @Test
    void effortPolicyTieKeepsFirst() {
        ProjectTask a = createTask("3", "a", 5, TaskStatus.NEW);
        ProjectTask b = createTask("4", "b", 5, TaskStatus.DONE);
        TaskPrioritizer t = new TaskPrioritizer(new EffortPriorityPolicy());
        assertSame(a, t.pickHigher(a, b));
    }

    @Test
    void statusPolicyPrefersInProgress() {
        ProjectTask inProg = createTask("5", "x", 1, TaskStatus.IN_PROGRESS);
        ProjectTask done   = createTask("6", "y", 100, TaskStatus.DONE);
        TaskPrioritizer t = new TaskPrioritizer(new StatusPriorityPolicy());
        assertSame(inProg, t.pickHigher(done, inProg));
    }

    @Test
    void statusPolicyOrdersNewOverDone() {
        ProjectTask n = createTask("7", "n", 1, TaskStatus.NEW);
        ProjectTask d = createTask("8", "d", 1, TaskStatus.DONE);
        TaskPrioritizer t = new TaskPrioritizer(new StatusPriorityPolicy());
        assertSame(n, t.pickHigher(d, n));
    }

    @Test
    void policyIsSwappableWithoutChangingPrioritizer() {
        ProjectTask done = createTask("9", "done", 100, TaskStatus.DONE);
        ProjectTask prog = createTask("10", "prog", 1,   TaskStatus.IN_PROGRESS);

        TaskPrioritizer byEffort = new TaskPrioritizer(new EffortPriorityPolicy());
        TaskPrioritizer byStatus = new TaskPrioritizer(new StatusPriorityPolicy());

        assertSame(done, byEffort.pickHigher(done, prog));
        assertSame(prog, byStatus.pickHigher(done, prog));
    }
}