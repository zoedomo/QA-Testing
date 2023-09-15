package task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        taskService = new TaskService();
    }

    @Test
    public void testAddTask() {
        String taskId = "1234567890";
        String name = "Name";
        String description = "Description";

        Task task = new Task(taskId, name, description);
        taskService.addTask(task);

        // verify that task is added correctly
        Task retrievedTask = taskService.getTask(taskId);
        Assertions.assertEquals(task, retrievedTask);
    }

    @Test
    public void testDeleteTask() {
        String taskId = "1234567890";
        String name = "Name";
        String description = "Description";

        Task task = new Task(taskId, name, description);
        taskService.addTask(task);

        taskService.deleteTask(taskId);

        // verify that task is deleted successfully
        Task retrievedTask = taskService.getTask(taskId);
        Assertions.assertNull(retrievedTask);
    }

    @Test
    public void testUpdateTaskName() {
        String taskId = "1234567890";
        String name = "Name";
        String description = "Description";

        Task task = new Task(taskId, name, description);
        taskService.addTask(task);

        String updatedName = "Updated Name";
        taskService.updateTaskName(taskId, updatedName);

        // verify that task name is updated correctly
        Task retrievedTask = taskService.getTask(taskId);
        Assertions.assertEquals(updatedName, retrievedTask.getName());
    }

    @Test
    public void testUpdateTaskDescription() {
        String taskId = "1234567890";
        String name = "Name";
        String description = "Description";

        Task task = new Task(taskId, name, description);
        taskService.addTask(task);

        String updatedDescription = "Updated Description";
        taskService.updateTaskDescription(taskId, updatedDescription);

        // verify that task description is updated correctly
        Task retrievedTask = taskService.getTask(taskId);
        Assertions.assertEquals(updatedDescription, retrievedTask.getDescription());
    }
}