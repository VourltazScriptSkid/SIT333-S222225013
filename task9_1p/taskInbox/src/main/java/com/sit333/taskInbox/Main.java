package com.sit333.taskInbox;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main{

    private static List<Task> getMockDatabase() {
        return Arrays.asList(
            new Task("1", "S222225013", "Task 1", "Do Java logic", "Submitted", LocalDate.of(2025, 5, 10), "Distinction", "Good work"),
            new Task("2", "S222225013", "Task 2", "Write report", "Completed", LocalDate.of(2025, 5, 12), "Distinction", "Well written"),
            new Task("3", "S222225013", "Task 3", "TDD and CI", "In Progress", LocalDate.of(2025, 5, 20), null, null),
            new Task("4", "S123456", "Task A", "Draft doc", "Submitted", LocalDate.of(2025, 5, 11), "Credit", "Try to explain more"),
            new Task("5", "S123456", "Task B", "Presentation", "Completed", LocalDate.of(2025, 5, 15), "High Distinction", "Excellent slides"),
            new Task("6", "S123456", "Portfolio", "Final submission", "Completed", LocalDate.of(2025, 6, 1), "High Distinction", "Outstanding")
        );
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskService service = new TaskService();
        List<Task> allTasks = getMockDatabase();

        System.out.print("Enter your student ID: ");
        String studentId = scanner.nextLine().trim();

        List<Task> studentTasks = service.getTaskInbox(studentId, allTasks);

        if (studentTasks.isEmpty()) {
            System.out.println("No tasks found for student ID: " + studentId);
        } else {
            System.out.println("\nTasks for student: " + studentId);
            System.out.println("----------------------------------");
            for (Task task : studentTasks) {
                System.out.println("Title: " + task.getTitle());
                System.out.println("Status: " + task.getStatus());
                System.out.println("Due: " + task.getDueDate());
                System.out.println("Mark: " + (task.getMark() != null ? task.getMark() : "N/A"));
                System.out.println("Feedback: " + (task.getFeedback() != null ? task.getFeedback() : "N/A"));
                System.out.println("----------------------------------");
            }
        }

        scanner.close();
    }
}