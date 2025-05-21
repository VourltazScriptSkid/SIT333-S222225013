package com.sit333.taskInbox;

import java.util.List;
import java.util.stream.Collectors;

public class TaskService {

    
    public List<Task> getTaskInbox(String studentId, List<Task> tasks) {
        if (studentId == null || tasks == null) {
            return List.of();
        }

        return tasks.stream()
                .filter(task -> task.getStudentId().equals(studentId))
                .collect(Collectors.toList());
    }


    public Task getTaskDetails(String taskId, List<Task> tasks) {
        if (taskId == null || tasks == null) {
            return null;
        }

        return tasks.stream()
                .filter(task -> task.getTaskId().equals(taskId))
                .findFirst()
                .orElse(null);
    }
}
