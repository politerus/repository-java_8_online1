package ua.com.alevel.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "groups") // Изменено на "groups", так как "Groups" может быть зарезервированным словом в некоторых СУБД
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groupId;

    @Column(name = "group_name", nullable = false)
    private String groupName;

    // Конструкторы
    public Group() {
    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    // Геттеры и сеттеры
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

    // Переопределение toString
    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
