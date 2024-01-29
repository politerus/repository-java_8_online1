package ua.com.alevel.service;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class CsvExportService {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/Students";
    private static final String USER = "root";
    private static final String PASSWORD = "11";

    public void exportTransactionsToCsv(Long accountId, LocalDate startDate, LocalDate endDate) {
        String query = "SELECT * FROM transactions WHERE account_id = ? AND date BETWEEN ? AND ?";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query);
             FileWriter fileWriter = new FileWriter("transactions.csv")) {

            statement.setLong(1, accountId);
            statement.setDate(2, java.sql.Date.valueOf(startDate));
            statement.setDate(3, java.sql.Date.valueOf(endDate));
            ResultSet resultSet = statement.executeQuery();

            fileWriter.write("ID,Amount,Date,AccountID,CategoryID\n");
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                double amount = resultSet.getDouble("amount");
                LocalDate date = resultSet.getDate("date").toLocalDate();
                long categoryId = resultSet.getLong("category_id");
                fileWriter.write(id + "," + amount + "," + date + "," + accountId + "," + categoryId + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}