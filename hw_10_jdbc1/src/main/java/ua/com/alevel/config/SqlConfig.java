package ua.com.alevel.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlConfig {
    private static final SqlConfig instance = new SqlConfig();
    private final Connection connection;

    private SqlConfig() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            String url = "jdbc:mysql://localhost:3306/";
            String dbName = "Students";
            String fullUrl = url + dbName;
            String user = "admin";
            String password = "password";


            connection = DriverManager.getConnection(fullUrl, user, password);


            try (Statement statement = connection.createStatement()) {
                String sqlCreateTableGroups = "CREATE TABLE IF NOT EXISTS `Groups` (" +
                        "group_id INT AUTO_INCREMENT PRIMARY KEY," +
                        "group_name VARCHAR(255) NOT NULL)";
                statement.executeUpdate(sqlCreateTableGroups);

                String sqlCreateTableStudents = "CREATE TABLE IF NOT EXISTS Students (" +
                        "student_id INT AUTO_INCREMENT PRIMARY KEY," +
                        "name VARCHAR(255) NOT NULL," +
                        "group_id INT," +
                        "FOREIGN KEY (group_id) REFERENCES `Groups`(group_id))";
                statement.executeUpdate(sqlCreateTableStudents);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlConfig getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
