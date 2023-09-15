package task;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private Map<String, Task> taskMap;

    public TaskService() {
        taskMap = new HashMap<>();
    }

    // add a task to taskMap if it does not exist already
    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }

        String taskId = task.getTaskId();
        if (taskId == null || taskId.isEmpty()) {
            throw new IllegalArgumentException("Task ID cannot be null or empty");
        }

        if (taskMap.containsKey(taskId)) {
            throw new IllegalArgumentException("Task with the same ID already exists");
        }

        taskMap.put(taskId, task);
    }

    // delete a task from taskMap based on its taskId
    public void deleteTask(String taskId) {
        if (!taskMap.containsKey(taskId)) {
            throw new IllegalArgumentException("Task with the given ID does not exist");
        }
        
        taskMap.remove(taskId);
    }

    // update the name of a task in the taskMap based on its taskId
    // returns true if the task is found and updated, false if not
    public boolean updateTaskName(String taskId, String newName) {
        Task task = taskMap.get(taskId);
        if (task == null) {
            return false;
        }
        
        task.setName(newName);
        return true;
    }

    // update the description of a task in the taskMap based on its taskId
    // returns true if task is found and updated, false if not
    public boolean updateTaskDescription(String taskId, String newDescription) {
        Task task = taskMap.get(taskId);
        if (task == null) {
            return false;
        }
        
        task.setDescription(newDescription);
        return true;
    }

    // retrieve a task from the taskMap based on its taskId
    public Task getTask(String taskId) {
        return taskMap.get(taskId);
    }
}

