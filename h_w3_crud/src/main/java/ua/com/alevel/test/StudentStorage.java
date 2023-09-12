package ua.com.alevel.test;

import java.util.Arrays;

class StudentStorage {
    private Student[] students;
    private int size;

    public StudentStorage() {
        students = new Student[10];
        size = 0;
    }

    public void addStudent(Student student) {
        if (size == students.length) {
            students = Arrays.copyOf(students, size * 2);
        }
        students[size++] = student;
    }

    public Student[] getStudents() {
        return Arrays.copyOf(students, size);
    }

    public void updateStudent(int index, Student updatedStudent) {
        if (index >= 0 && index < size) {
            students[index] = updatedStudent;
        } else {
            System.out.println("Invalid index. Student not updated.");
        }
    }

    public void deleteStudent(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                students[i] = students[i + 1];
            }
            size--;
        } else {
            System.out.println("Invalid index. Student not deleted.");
        }
    }
}