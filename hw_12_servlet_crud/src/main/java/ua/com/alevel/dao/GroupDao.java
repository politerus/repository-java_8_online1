package ua.com.alevel.dao;

import ua.com.alevel.entity.Group;

import java.util.List;

public interface GroupDao {
    void create(Group group);
    void update(Group group);
    void delete(int groupId);
    Group findById(int groupId);


    List<Group> findAll();
}


