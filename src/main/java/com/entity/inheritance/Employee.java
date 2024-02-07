package com.entity.inheritance;

import javax.persistence.*;

@MappedSuperclass
public abstract class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    public Employee() {
    }

    public Employee(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
