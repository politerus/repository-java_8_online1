package ua.com.alevel.dao;

import ua.com.alevel.config.SqlConfig;
import ua.com.alevel.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private static final String INSERT_STUDENT = "INSERT INTO Students (name, group_id) VALUES (?, ?)";
    private static final String SELECT_STUDENT_BY_ID = "SELECT * FROM Students WHERE student_id = ?";
    private static final String UPDATE_STUDENT = "UPDATE Students SET name = ?, group_id = ? WHERE student_id = ?";
    private static final String DELETE_STUDENT = "DELETE FROM Students WHERE student_id = ?";
    private static final String SELECT_ALL_STUDENTS = "SELECT * FROM Students";

    private final Connection connection;

    public StudentDaoImpl() {
        this.connection = SqlConfig.getInstance().getConnection();
    }

    @Override
    public void create(Student student) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_STUDENT, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, student.name());
            statement.setInt(2, student.groupId());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    student.setStudentId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Создание студента не удалось, ID не получен.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении студента: " + e.getMessage());
        }
    }

    public void update(Student student) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT)) {
            statement.setString(1, student.name());
            if (student.groupId() == 0) {
                statement.setNull(2, Types.INTEGER);
            } else {
                statement.setInt(2, student.groupId());
            }
            statement.setInt(3, student.studentId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int studentId) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT)) {
            statement.setInt(1, studentId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Student findById(int studentId) {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {
            statement.setInt(1, studentId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Student(
                            resultSet.getInt("student_id"),
                            resultSet.getString("name"),
                            resultSet.getInt("group_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_STUDENTS)) {
            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getInt("student_id"),
                        resultSet.getString("name"),
                        resultSet.getInt("group_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
