package ru.zarya.spring.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zarya.spring.config.dao.UserDao;
import ru.zarya.spring.config.models.User;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> showUser() {
        return userDao.showUser();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);

    }

    @Override
    @Transactional
    public void updateUser(int id, User user) {
        userDao.updateUser(id, user);

    }

    @Override
    @Transactional
    public void removeUser(int id) {
        userDao.removeUser(id);

    }

    @Override
    @Transactional
    public User getUser(int id) {
        return userDao.getUser(id);
    }
}