package com.sit333.taskInbox;

import java.time.LocalDate;

public class Task {
    private String taskId;
    private String studentId;
    private String title;
    private String description;
    private String status;
    private LocalDate dueDate;
    private String mark;
    private String feedback;

    public Task(String taskId, String studentId, String title, String description,
                String status, LocalDate dueDate, String mark, String feedback) {
        this.taskId = taskId;
        this.studentId = studentId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
        this.mark = mark;
        this.feedback = feedback;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getMark() {
        return mark;
    }

    public String getFeedback() {
        return feedback;
    }

    @Override
    public String toString() {
        return title + " (" + status + ") - Due: " + dueDate;
    }
}
