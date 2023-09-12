package ua.com.alevel;

import java.util.Scanner;

public class Main extends  StudentGroupManagement{
    public Main(int maxStudents, int maxGroups) {
        super(maxStudents, maxGroups);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGroupManagement management = new StudentGroupManagement(100, 50);

        while (true) {
            System.out.println("\nStudent and Group Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Add Group");
            System.out.println("3. List Students");
            System.out.println("4. List Groups");
            System.out.println("5. Assign Student to Group");
            System.out.println("6. Remove Student from Group");
            System.out.println("7. Delete Student");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    management.addStudent(new Student(studentId, studentName, 0));
                    System.out.println("Student added successfully!");
                }
                case 2 -> {
                    System.out.print("Enter Group ID: ");
                    int groupId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Group Name: ");
                    String groupName = scanner.nextLine();
                    management.addGroup(new Group(groupId, groupName));
                    System.out.println("Group added successfully!");
                }
                case 3 -> management.listStudents();
                case 4 -> management.listGroups();
                case 5 -> {
                    System.out.print("Enter Student ID to assign: ");
                    int assignStudentId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Group ID to assign: ");
                    int assignGroupId = scanner.nextInt();
                    scanner.nextLine();
                    management.assignStudentToGroup(assignStudentId, assignGroupId);
                }
                case 6 -> {
                    System.out.print("Enter Student ID to remove from group: ");
                    int removeStudentId = scanner.nextInt();
                    scanner.nextLine();
                    management.removeStudentFromGroup(removeStudentId);
                }
                case 7 -> {
                    System.out.print("Enter Student ID to delete: ");
                    int deleteStudentId = scanner.nextInt();
                    scanner.nextLine();
                    management.deleteStudent(deleteStudentId);
                }
                case 8 -> {
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}

