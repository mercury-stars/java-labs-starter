package edu.course.lab02;

public class ProjectTask {
    private final String id;
    private final String title;
    private TaskStatus status;
    private int estimatedHours;

    public ProjectTask(String id, String title, int estimatedHours) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id не может быть пустым");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("заголовок не может быть пустым");
        }

        if (estimatedHours < 0) {
            throw new IllegalArgumentException("часы не могут быть меньше нуля");

        }

        this.id = id;
        this.title = title;
        this.estimatedHours = estimatedHours;
        this.status = TaskStatus.NEW;
    }

    public void changeStatus(TaskStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("статус не может быть нулевым");
        }
        this.status = newStatus;
    }

    public boolean isCompleted() {
        return this.status == TaskStatus.DONE;
    }

    public void increaseEstimatedHours(int hours) {
        if (hours <= 0) {
            throw new IllegalArgumentException("часы должны быть положительными");

        }
        this.estimatedHours += hours;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }

}

