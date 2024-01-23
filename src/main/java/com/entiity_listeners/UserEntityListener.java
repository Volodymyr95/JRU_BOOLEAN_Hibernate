package com.entiity_listeners;

import com.entity.User;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import java.util.Objects;

public class UserEntityListener {
    @PrePersist
    public void prePersist(Object entity) {
        if (entity instanceof User) {
            System.out.println(entity);
        }
        System.out.println("Pre persist");
    }


    @PostLoad
    public void postLoad(Object entity) {
        if (entity instanceof User) {
            System.out.println(entity);
        }
        System.out.println("Post Load!");
    }
}
