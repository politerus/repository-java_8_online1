package ua.com.alevel.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    public Student() {
        // Пустой конструктор
    }

    public Student(int studentId, String name, Group group) {
        this.studentId = studentId;
        this.name = name;
        this.group = group;
    }
    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", group=" + (group != null ? group.getGroupName() : "None") +
                '}';
    }

    public void setName(String name) {

    }

    public String getName() {
        return name;
    }

    public Group getGroup() {
        return group;
    }

    public Object getStudentId() {
        return null;
    }
}
