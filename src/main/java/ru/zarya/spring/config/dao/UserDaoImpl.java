package ru.zarya.spring.config.dao;




import org.springframework.stereotype.Component;

import ru.zarya.spring.config.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    static private final String url = "jdbc:mysql://localhost:3306/mydbtest";
    static private final String name = "root";
    static private final String pass = "12enigmA123!";
    private static Connection connection;

    public static Connection getConnection(){
        try {
            connection = DriverManager.getConnection(url, name,pass);
            System.out.println("Соединение установленно");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<User> index() {
        List<User> user = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM user";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()) {
                User person = new User();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));


                user.add(person);
                System.out.println(person);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public void save(User user1) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO user VALUES (1,?,?,?)");
            preparedStatement.setString(1,user1.getName());
            preparedStatement.setInt(2,user1.getAge());
            preparedStatement.setString(3,user1.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }




    }


    @Override
    public User show(int id) {
        User user = null;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM user");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setAge(resultSet.getInt("age"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }



    @Override
    public void update(int id, User updatedUser) {
      //  User userToBeUpdated = show(id);
      //  userToBeUpdated.setName(updatedUser.getName());
      //  userToBeUpdated.setAge(updatedUser.getAge());
      //  userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    @Override
    public void delete(int id) {
      //  user.removeIf(u -> u.getId() == id);
    }

}