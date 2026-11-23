package edu.course.lab04;

public final class ProjectTask {
    private final String title;
    private int estimatedHours;

    public ProjectTask(String title, int estimatedHours) {
        this.title = title;
        this.estimatedHours = estimatedHours;
    }

    public String getTitle() { 
        return title; 
    
    }
    public int getEstimatedHours() { 
        return estimatedHours; 
    }

    public void increaseEstimatedHours(int hours) { 
        this.estimatedHours += hours;
    }
}
