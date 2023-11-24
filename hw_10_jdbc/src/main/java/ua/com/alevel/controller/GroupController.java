package ua.com.alevel.controller;

import ua.com.alevel.entity.Group;
import ua.com.alevel.service.GroupService;

import java.util.List;

public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    public void addGroup(Group group) {
        groupService.addGroup(group);
    }

    public void updateGroup(Group group) {
        groupService.updateGroup(group);
    }

    public void deleteGroup(int groupId) {
        groupService.deleteGroup(groupId);
    }

    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }
}
