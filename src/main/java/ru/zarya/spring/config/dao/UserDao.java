package ru.zarya.spring.config.dao;

import ru.zarya.spring.config.models.User;

import java.sql.Connection;
import java.util.List;

public interface UserDao {
    List<User> index();
    void save(User user);
    void update(int id,User updatedUser);
    void delete(int id);
    User show(int id);

}