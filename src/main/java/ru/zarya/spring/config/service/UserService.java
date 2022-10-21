package ru.zarya.spring.config.service;



import ru.zarya.spring.config.models.User;

import java.util.List;

public interface UserService {
    List<User> showUser();
    void saveUser(User user);
    void updateUser(int id,User user);
    void removeUser(int id);
    User getUser(int id);
}