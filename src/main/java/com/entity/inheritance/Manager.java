package com.entity.inheritance;

import javax.persistence.Entity;

@Entity
public class Manager extends Employee {

    private String team;

    public Manager() {

    }

    public Manager(String username, String email, String team) {
        super(username, email);
        this.team = team;
    }
}
