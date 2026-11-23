package edu.course.lab04;

import java.util.Objects;

public class IssueId {
    private final String projectCode;
    private final int number;

    public IssueId(String projectCode, int number) {
        if (projectCode == null || projectCode.isBlank()) {
            throw new IllegalArgumentException("не должен быть пустым");
        }
        if (number <= 0) {
            throw new IllegalArgumentException("должен быть положительным");
        }
        this.projectCode = projectCode;
        this.number = number;
    }

    public String getProjectCode() {
        return projectCode;
    }
    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IssueId other)) {
            return false;
        }

        return number == other.number && projectCode.equals(other.projectCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectCode, number);
    }

    @Override
    public String toString() {
        return projectCode + " " + number;
    }
    
}
