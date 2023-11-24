package ua.com.alevel.entity;

public record Group(int groupId, String groupName) {

    @Override
    public String toString() {
        return "Group ID: " + groupId + ", Group Name: " + groupName;
    }

    public void setGroupId(int anInt) {
    }
}
