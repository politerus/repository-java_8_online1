package ua.com.alevel.controller;

import ua.com.alevel.service.StudentService;
import ua.com.alevel.entity.Student;

import java.util.List;

public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public void addStudent(Student student) {
        studentService.addStudent(student);
    }

    public void updateStudent(Student student) {
        studentService.updateStudent(student);
    }

    public void deleteStudent(int studentId) {
        studentService.deleteStudent(studentId);
    }

    public Student getStudentById(int studentId) {
        return studentService.getStudentById(studentId);
    }

    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}