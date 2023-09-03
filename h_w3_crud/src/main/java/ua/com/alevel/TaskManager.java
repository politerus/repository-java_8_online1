package ua.com.alevel;
import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskStorage storage = new TaskStorage();

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Task Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Task Description: ");
                    String description = scanner.nextLine();
                    Task task = new Task(storage.getAllTasks().size() + 1, title, description);
                    if (task.isValid()) {
                        storage.addTask(task);
                        System.out.println("Task added successfully.");
                    } else {
                        System.out.println("Invalid task input. Title and description cannot be empty.");
                    }
                }
                case 2 -> {
                    System.out.println("All Tasks:");
                    for (Task t : storage.getAllTasks()) {
                        System.out.println(t.getId() + ".  " + t.getTitle() + "   " + t.getDescription());
                    }
                }
                case 3 -> {
                    System.out.print("Enter Task ID to Update: ");
                    int updateId = scanner.nextInt();
                    Task taskToUpdate = storage.getTask(updateId);
                    if (taskToUpdate != null) {
                        System.out.print("Enter New Task Title: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Enter New Task Description: ");
                        String newDescription = scanner.nextLine();
                        taskToUpdate.setTitle(newTitle);
                        taskToUpdate.setDescription(newDescription);
                        System.out.println("Task updated successfully.");
                    } else {
                        System.out.println("Task not found with ID: " + updateId);
                    }
                }
                case 4 -> {
                    System.out.print("Enter Task ID to Delete: ");
                    int deleteId = scanner.nextInt();
                    Task taskToDelete = storage.getTask(deleteId);
                    if (taskToDelete != null) {
                        storage.deleteTask(deleteId);
                        System.out.println("Task deleted successfully.");
                    } else {
                        System.out.println("Task not found with ID: " + deleteId);
                    }
                }
                case 5 -> {
                    System.out.println("Exiting Task Manager. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}