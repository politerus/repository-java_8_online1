package ua.com.alevel.dao;

import ua.com.alevel.config.SqlConfig;
import ua.com.alevel.entity.Group;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupDaoImpl implements GroupDao {


     private static final String INSERT_GROUP = "INSERT INTO `Groups` (group_name) VALUES (?)";
    private static final String UPDATE_GROUP = "UPDATE `Groups` SET group_name = ? WHERE group_id = ?";
    private static final String DELETE_GROUP = "DELETE FROM `Groups` WHERE group_id = ?";
    private static final String SELECT_ALL_GROUPS = "SELECT * FROM `Groups`";

    private final Connection connection;

    public GroupDaoImpl() {
        this.connection = SqlConfig.getInstance().getConnection();
    }

    @Override
    public void create(Group group) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_GROUP, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, group.groupName());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    group.setGroupId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Создание группы не удалось, ID не получен.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении группы: " + e.getMessage());

        }
    }

    @Override
    public void update(Group group) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_GROUP)) {
            statement.setString(1, group.groupName());
            statement.setInt(2, group.groupId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int groupId) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_GROUP)) {
            statement.setInt(1, groupId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Group> findAll() {
        List<Group> groups = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_GROUPS)) {
            while (resultSet.next()) {
                groups.add(new Group(
                        resultSet.getInt("group_id"),
                        resultSet.getString("group_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groups;
    }
}
