package ua.com.alevel.entity;

import javax.persistence.*;
@Entity
@Table(name = "`Groups`")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groupId;

    @Column(name = "group_name", nullable = false)
    private String groupName;

    public Group() {
    }


    public Group(int groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }



    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
