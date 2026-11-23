package edu.course.lab04;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class IssueRegistry {
    private final Map<IssueId, ProjectTask> tasks = new HashMap<>();

    public ProjectTask put(IssueId id, ProjectTask task) {
        Objects.requireNonNull(id, "id");
        Objects.requireNonNull(task, "task");
        return tasks.put(id, task);
    }

    public ProjectTask get(IssueId id) {
        return tasks.get(id);
    }

    public ProjectTask remove(IssueId id) {
        return tasks.remove(id);
    }

    public boolean contains(IssueId id) {
        return tasks.containsKey(id);
    }

    public int size() {
        return tasks.size();
    }
    
}
