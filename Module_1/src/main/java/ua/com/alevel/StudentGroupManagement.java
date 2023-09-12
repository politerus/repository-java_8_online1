package ua.com.alevel;



class StudentGroupManagement  {
    private final Student[] students;
    private final Group[] groups;
    private int studentCount;
    private int groupCount;

    public StudentGroupManagement(int maxStudents, int maxGroups) {

        students = new Student[maxStudents];
        groups = new Group[maxGroups];
        studentCount = 0;
        groupCount = 0;
    }

    public void addStudent(Student student) {
        students[studentCount++] = student;
    }

    public void addGroup(Group group) {
        groups[groupCount++] = group;
    }

    public void listStudents() {
        System.out.println("List of Students:");
        for (int i = 0; i < studentCount; i++) {
            System.out.println((i + 1) + ". " + students[i]);
        }
    }

    public void listGroups() {
        System.out.println("List of Groups:");
        for (int i = 0; i < groupCount; i++) {
            System.out.println((i + 1) + ". " + groups[i]);
        }
    }
    public void assignStudentToGroup(int studentId, int groupId) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId() == studentId) {
                students[i] = new Student(students[i].getStudentId(), students[i].getName(), groupId);
                System.out.println("Student assigned to the group successfully!");
                return;
            }
        }
        System.out.println("Student or group not found.");
    }

    public void removeStudentFromGroup(int studentId) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId() == studentId) {
                students[i] = new Student(students[i].getStudentId(), students[i].getName(), 0);
                System.out.println("Student removed from the group successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void deleteStudent(int studentId) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId() == studentId) {
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[--studentCount] = null;
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    }

