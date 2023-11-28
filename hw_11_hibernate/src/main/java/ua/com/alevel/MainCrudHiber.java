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

public class MainCrudHiber {
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
                    System.out.print("Введите имя студента: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();

                    System.out.print("Введите ID группы студента: ");
                    int groupId = scanner.nextInt();
                    scanner.nextLine();

                    Group group = groupController.getGroupById(groupId);
                    if (group != null) {
                        studentController.addStudent(new Student(0, name, group));
                        System.out.println("Студент добавлен.");
                    } else {
                        System.out.println("Группа с таким ID не существует.");
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

                    Group groupToUpdate = newGroupId == 0 ? existingStudent.getGroup() : groupController.getGroupById(newGroupId);
                    studentController.updateStudent(new Student(id, newName, groupToUpdate));

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

                    Group newGroup = new Group();
                    newGroup.setGroupName(groupName);

                    groupController.addGroup(newGroup);

                    System.out.println("Група додана.");
                    break;
                }
                case 6: {
                    System.out.print("Введіть ID групи для видалення: ");
                    int groupId = scanner.nextInt();

                    // Удаление или обновление всех студентов в группе
                    List<Student> studentsInGroup = studentService.findStudentsByGroupId(groupId);
                    for (Student student : studentsInGroup) {
                        student.setGroup(null); // Обнуляем группу у студента
                        studentService.updateStudent(student); // Обновляем студента
                    }

                    // Теперь можно безопасно удалить группу
                    groupService.deleteGroup(groupId);

                    System.out.println("Група видалена.");
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
                    groups.forEach(group -> System.out.println("ID: " + group.getGroupId() + ", Назва: " + group.getGroupName()));
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

