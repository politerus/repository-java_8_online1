package ua.com.alevel.service;

import ua.com.alevel.dao.GroupDao;
import ua.com.alevel.entity.Group;
import java.util.List;

public class GroupService {
    private final GroupDao groupDao;

    public GroupService(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    public void addGroup(Group group) {
        groupDao.create(group);
    }

    public void updateGroup(Group group) {
        groupDao.update(group);
    }

    public void deleteGroup(int groupId) {
        groupDao.delete(groupId);
    }

    public Group getGroupById(int groupId) {
        return groupDao.findById(groupId);
    }

    public List<Group> getAllGroups() {
        return groupDao.findAll();
    }
}
