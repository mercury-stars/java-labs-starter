package edu.course.lab03;

public class TaskPrioritizer {
    private final PriorityPolicy policy;

    public TaskPrioritizer(PriorityPolicy policy) {
        if (policy == null){
            throw new IllegalArgumentException("policy != null");
        } else {
        this.policy = policy;
        }
    }
    public ProjectTask pickHigher(ProjectTask a, ProjectTask b) {

        int priorityA = policy.calculatePriority(a);
        int priorityB = policy.calculatePriority(b);

        if (priorityA >= priorityB) {
            return a;
        } else {
            return b;
        }
    }
}
