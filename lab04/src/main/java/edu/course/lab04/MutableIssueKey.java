package edu.course.lab04;

import java.util.Objects;

final class MutableIssueKey {
    private String code;
    private int number;

    MutableIssueKey(String code, int number) {
        this.code = code;
        this.number = number;
    }

    void setNumber(int number) { this.number = number; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MutableIssueKey other)) {
            return false;
        }
        return number == other.number && code.equals(other.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, number);
    }
}