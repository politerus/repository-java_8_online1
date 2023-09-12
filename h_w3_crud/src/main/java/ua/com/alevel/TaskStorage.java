package ua.com.alevel;
import java.util.ArrayList;
import java.util.List;

public class TaskStorage {
    private final List<Task> tasks;

    public TaskStorage() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public Task getTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public void deleteTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }
}
