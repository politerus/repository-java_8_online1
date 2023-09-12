package ua.com.alevel;

class Group {
    private final int groupId;
    private final String groupName;

    public Group(int groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Group ID: " + groupId + ", Group Name: " + groupName;
    }
}
