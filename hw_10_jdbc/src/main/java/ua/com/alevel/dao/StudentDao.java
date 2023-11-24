package ua.com.alevel.dao;

import ua.com.alevel.entity.Student;

import java.util.List;

public interface StudentDao {
    void create(Student student);

    void update(Student student);
    void delete(int studentId);
    Student findById(int studentId);

    List<Student> findAll();
}
