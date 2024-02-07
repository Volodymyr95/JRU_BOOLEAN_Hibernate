package com.entity.inheritance;

import javax.persistence.Entity;

@Entity
public class Developer extends Employee {

    private String skill;

    public Developer() {
    }

    public Developer(String username, String email, String skill) {
        super(username, email);
        this.skill = skill;
    }
}
