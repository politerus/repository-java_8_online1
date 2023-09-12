package ua.com.alevel;



class Student {
    private final int studentId;
    private final String name;
    private final int groupId;

    public Student(int studentId, String name, int groupId) {
        this.studentId = studentId;
        this.name = name;
        this.groupId = groupId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + name + ", Group ID: " + groupId;
    }
}