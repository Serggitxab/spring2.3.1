package ru.zarya.spring.config.dao;

public class test {
    public static void main(String[] args) {
        UserDaoImpl.getConnection();
        UserDaoImpl test = new UserDaoImpl();
        test.index();
    }
}
