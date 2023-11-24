package ua.com.alevel.entity;

public record Student(int studentId, String name, int groupId) {
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + name + ", Group ID: " + groupId;
    }


    public void setStudentId(int anInt) {

    }
}