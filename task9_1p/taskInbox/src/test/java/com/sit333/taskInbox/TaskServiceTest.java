// Trigger CI

package com.sit333.taskInbox;

import org.junit.Test;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class TaskServiceTest {

    private List<Task> getSampleTasks() {
        return Arrays.asList(
                new Task("1", "S222225013", "Task 1", "Do Java logic", "Submitted", LocalDate.of(2025, 5, 10), "Distinction", "Good work"),
                new Task("2", "S222225013", "Task 2", "Write report", "Completed", LocalDate.of(2025, 5, 12), "Distinction", "Well written"),
                new Task("3", "S222225013", "Task 3", "TDD and CI", "In Progress", LocalDate.of(2025, 5, 20), null, null),
                new Task("4", "S123456", "Task A", "Draft doc", "Submitted", LocalDate.of(2025, 5, 11), "Credit", "Try to explain more"),
                new Task("5", "S123456", "Task B", "Presentation", "Completed", LocalDate.of(2025, 5, 15), "High Distinction", "Excellent slides"),
                new Task("6", "S123456", "Portfolio", "Final submission", "Completed", LocalDate.of(2025, 6, 1), "High Distinction", "Outstanding")
        );
    }

    @Test
    public void testGetTaskInbox_S222225013() {
        TaskService service = new TaskService();
        List<Task> tasks = service.getTaskInbox("S2222250", getSampleTasks());

        assertEquals(3, tasks.size());
        assertEquals("Task 1", tasks.get(0).getTitle());
        assertEquals("Task 3", tasks.get(2).getTitle());
    }

    @Test
    public void testGetTaskInbox_S123456() {
        TaskService service = new TaskService();
        List<Task> tasks = service.getTaskInbox("S1236", getSampleTasks());

        assertEquals(3, tasks.size());
        assertEquals("Task A", tasks.get(0).getTitle());
        assertEquals("Portfolio", tasks.get(2).getTitle());
    }
    @Test
    public void testGetTaskInbox_UnknownStudent() {
        TaskService service = new TaskService();
        List<Task> tasks = service.getTaskInbox("UNKNOWN", getSampleTasks());

        assertTrue(tasks.isEmpty());
    }

    @Test
    public void testGetTaskInbox_EmptyList() {
        TaskService service = new TaskService();
        List<Task> tasks = service.getTaskInbox("SIT333", Collections.emptyList());

        assertTrue(tasks.isEmpty());
    }

    @Test
    public void testGetTaskInbox_NullInput() {
        TaskService service = new TaskService();
        List<Task> tasks = service.getTaskInbox(null, getSampleTasks());

        assertTrue(tasks.isEmpty());
    }

    @Test
    public void testGetTaskDetails_ValidId() {
        TaskService service = new TaskService();
        Task task = service.getTaskDetails("2", getSampleTasks());

        assertNotNull(task);
        assertEquals("Task 2", task.getTitle());
        assertEquals("Completed", task.getStatus());
    }

    @Test
    public void testGetTaskDetails_InvalidId() {
        TaskService service = new TaskService();
        Task task = service.getTaskDetails("999", getSampleTasks());

        assertNull(task);
    }

    @Test
    public void testGetTaskDetails_NullId() {
        TaskService service = new TaskService();
        Task task = service.getTaskDetails(null, getSampleTasks());

        assertNull(task);
    }
}
