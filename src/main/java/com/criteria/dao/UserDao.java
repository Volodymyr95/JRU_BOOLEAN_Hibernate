package com.criteria.dao;

import com.dto.UserDto;
import com.entity.User;
import com.entity.UserTask;
import config.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import javax.persistence.criteria.*;
import java.util.List;

public class UserDao {
    private Session session;
    private CriteriaBuilder criteriaBuilder;

    public UserDao(Session session) {
        this.session = session;
        criteriaBuilder = session.getCriteriaBuilder();
    }

    public void getAllUsers() {
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> from = query.from(User.class);
        query.select(from);
        session.createQuery(query)
                .getResultList()
                .forEach(System.out::println);
    }

    public void getUsersByName(String name) {
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class); //select
        Root<User> from = query.from(User.class); // * from User
        query.select(from);// select * from user
        query.where(criteriaBuilder.equal(from.get("name"), name)); //select * from user + where name = ""
        session.createQuery(query)
                .getResultList()
                .forEach(System.out::println);
    }

    public void getAllUserTasks(Long id) {
        CriteriaQuery<UserTask> query = criteriaBuilder.createQuery(UserTask.class);
        Root<UserTask> from = query.from(UserTask.class);

        Join<UserTask, User> join = from.join("user");
        query.select(from);
        query.where(criteriaBuilder.equal(join.get("id"), id)); //select * from user + where id = ""
        session.createQuery(query)
                .getResultList()
                .forEach(System.out::println);
    }

    public void getAllSortedUsers() {
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> from = query.from(User.class);
        query.select(from);
        query.orderBy(criteriaBuilder.desc(from.get("id")));
        session.createQuery(query)
                .getResultList()
                .forEach(System.out::println);
    }


    public void updateUser(int age, long id) {
        CriteriaUpdate<User> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(User.class);
        Root<User> root = criteriaUpdate.from(User.class);
        criteriaUpdate.set("age", age);
        criteriaUpdate.where(criteriaBuilder.equal(root.get("id"), id));
        session.createQuery(criteriaUpdate).executeUpdate();
    }

    public void deleteUser(long id) {
        CriteriaDelete<User> criteriaUpdate = criteriaBuilder.createCriteriaDelete(User.class);
        Root<User> root = criteriaUpdate.from(User.class);
        criteriaUpdate.where(criteriaBuilder.equal(root.get("id"), id));
        session.createQuery(criteriaUpdate).executeUpdate();
    }

    public void selectAllUsers() {
        NativeQuery<User> query = session.createNativeQuery("SELECT * FROM User", User.class);
        query.getResultList()
                .forEach(System.out::println);
    }

    public void selectUserByName(String name) {
        NativeQuery<User> getUserByName = session.createNativeQuery("SELECT * FROM USER WHERE name = :name", User.class);
        getUserByName.setParameter("name", name);
        getUserByName.getResultList()
                .forEach(System.out::println);
    }

    public void selectUserDtos() {
        NativeQuery<UserDto> query = session.createNativeQuery("Select name FROM user ");
        query.addEntity(UserDto.class);
        List<UserDto> resultList = query.getResultList();
        resultList.forEach(System.out::println);


    }
}
