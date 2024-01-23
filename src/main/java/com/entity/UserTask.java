package com.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "task")
public class UserTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(name = "name")
    public String name;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    public User user;
    @Column(name = "deadline")
    public Date deadline;

    public UserTask() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "UserTask{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", deadline=" + deadline +
                '}';
    }
}
