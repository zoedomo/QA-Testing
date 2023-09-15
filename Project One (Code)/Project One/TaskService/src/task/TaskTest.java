package task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void testTaskInitialization() {
        String taskId = "1234567890";
        String name = "Name";
        String description = "Description";

        Task task = new Task(taskId, name, description);

        // verify that task is initialized correctly
        Assertions.assertEquals(taskId, task.getTaskId());
        Assertions.assertEquals(name, task.getName());
        Assertions.assertEquals(description, task.getDescription());
    }
}