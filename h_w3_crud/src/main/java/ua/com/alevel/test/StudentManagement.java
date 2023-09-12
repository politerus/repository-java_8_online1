package ua.com.alevel.test;

import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        StudentStorage storage = new StudentStorage();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add a Student");
            System.out.println("2. List Students");
            System.out.println("3. Update a Student");
            System.out.println("4. Delete a Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    Student newStudent = new Student(studentId, name, age);
                    storage.addStudent(newStudent);
                    System.out.println("Student added successfully!");
                }
                case 2 -> {
                    Student[] students = storage.getStudents();
                    if (students.length == 0) {
                        System.out.println("No students in the system.");
                    } else {
                        System.out.println("List of Students:");
                        for (int i = 0; i < students.length; i++) {
                            System.out.println((i + 1) + ". " + students[i]);
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Enter the index of the student to update: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    if (index >= 0 && index < storage.getStudents().length) {
                        System.out.print("Enter new Student ID: ");
                        String newStudentId = scanner.nextLine();
                        System.out.print("Enter new Name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new Age: ");
                        int newAge = scanner.nextInt();
                        scanner.nextLine();
                        Student updatedStudent = new Student(newStudentId, newName, newAge);
                        storage.updateStudent(index, updatedStudent);
                        System.out.println("Student updated successfully!");
                    } else {
                        System.out.println("Invalid index. Student not updated.");
                    }
                }
                case 4 -> {
                    System.out.print("Enter the index of the student to delete: ");
                    int deleteIndex = scanner.nextInt();
                    scanner.nextLine();
                    storage.deleteStudent(deleteIndex);
                    System.out.println("Student deleted successfully!");
                }
                case 5 -> {
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}