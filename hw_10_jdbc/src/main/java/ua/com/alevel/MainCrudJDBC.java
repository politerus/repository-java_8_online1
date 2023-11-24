package ua.com.alevel;

import ua.com.alevel.controller.GroupController;
import ua.com.alevel.controller.StudentController;
import ua.com.alevel.dao.GroupDaoImpl;
import ua.com.alevel.dao.StudentDaoImpl;
import ua.com.alevel.entity.Group;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.GroupService;
import ua.com.alevel.service.StudentService;

import java.util.List;
import java.util.Scanner;

public class MainCrudJDBC {
    public static void main(String[] args) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        GroupDaoImpl groupDao = new GroupDaoImpl();
        StudentService studentService = new StudentService(studentDao);
        GroupService groupService = new GroupService(groupDao);
        StudentController studentController = new StudentController(studentService);
        GroupController groupController = new GroupController(groupService);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Додати студента");
            System.out.println("2. Видалити студента");
            System.out.println("3. Оновити дані студента");
            System.out.println("4. Показати всіх студентів");
            System.out.println("5. Додати групу");
            System.out.println("6. Видалити групу");
            System.out.println("7. Оновити дані групи");
            System.out.println("8. Показати всі групи");
            System.out.println("9. Вихід");
            System.out.print("Виберіть опцію: ");
            int choice;
            while (!scanner.hasNextInt()) {
                System.out.println("Це не число. Попробуйте еще раз:");
                scanner.next();
            }
            choice = scanner.nextInt();


            switch (choice) {
                case 1: {
                    System.out.print("Введіть ім'я студента: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();

                    System.out.print("Введіть ID групи студента: ");
                    int groupId = scanner.nextInt();
                    scanner.nextLine();

                    List<Group> groups = groupController.getAllGroups();
                    boolean groupExists = groups.stream().anyMatch(group -> group.groupId() == groupId);

                    if (groupExists) {
                        studentController.addStudent(new Student(0, name, groupId));
                        System.out.println("Студент добавлен.");
                    } else {
                        System.out.println("Група з таким ID не існує.");
                    }
                    break;
                }
                case 2: {
                    System.out.print("Введіть ID студента для видалення: ");
                    int id = scanner.nextInt();
                    studentController.deleteStudent(id);
                    break;
                }
                case 3: {
                    System.out.print("Введіть ID студента для оновлення: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Student existingStudent = studentController.getStudentById(id);
                    if (existingStudent == null) {
                        System.out.println("Студент з таким ID не знайдений.");
                        break;
                    }

                    System.out.print("Введіть нове ім'я студента: ");
                    String newName = scanner.nextLine();

                    System.out.print("Введіть новий ID групи для студента (або 0, якщо група залишаєтся): ");
                    int newGroupId = scanner.nextInt();
                    scanner.nextLine();


                    int groupIdToUpdate = newGroupId == 0 ? existingStudent.groupId() : newGroupId;

                    studentController.updateStudent(new Student(id, newName, groupIdToUpdate));
                    break;
                }
                case 4: {
                    List<Student> students = studentController.getAllStudents();
                    students.forEach(System.out::println);
                    break;
                }
                case 5: {
                    System.out.print("Введіть назву групи: ");
                    scanner.nextLine();
                    String groupName = scanner.nextLine();

                    groupController.addGroup(new Group(0, groupName));
                    break;
                }
                case 6: {
                    System.out.print("Введіть ID групи для видалення: ");
                    int groupId = scanner.nextInt();
                    groupController.deleteGroup(groupId);
                    break;
                }
                case 7: {
                    System.out.print("Введіть ID групи для оновлення: ");
                    int groupId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введіть нову назву групи: ");
                    String groupName = scanner.nextLine();
                    groupController.updateGroup(new Group(groupId, groupName));
                    break;
                }
                case 8: {
                    List<Group> groups = groupController.getAllGroups();
                    groups.forEach(group -> System.out.println("ID: " + group.groupId() + ", Назва: " + group.groupName()));
                    break;
                }
                case 9:
                    System.out.println("Вихід з програми.");
                    return;
                default:
                    System.out.println("Невірний вибір. Будь ласка, спробуйте знову.");
                    break;
            }
        }
    }
}
