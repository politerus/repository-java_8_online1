package ua.com.alevel.service;

import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.entity.Student;
import java.util.List;

public class StudentService {
    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void addStudent(Student student) {
        studentDao.create(student);
    }

    public void updateStudent(Student student) {
        studentDao.update(student);
    }

    public void deleteStudent(int studentId) {
        studentDao.delete(studentId);
    }

    public Student getStudentById(int studentId) {
        return studentDao.findById(studentId);
    }

    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    public List<Student> findStudentsByGroupId(int groupId) {
        return studentDao.findStudentsByGroupId(groupId);
    }
}
