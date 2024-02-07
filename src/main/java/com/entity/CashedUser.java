package com.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "cashed_user")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CashedUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public CashedUser() {
    }

    public CashedUser(String name) {
        this.name = name;
    }
}
