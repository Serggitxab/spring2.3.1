package ru.zarya.spring.config.models;

//import javax.validation.constraints.*;

public class User {

    private int id;


  //  @NotEmpty(message = "Name should not be empty")
  //  @Size(min = 2,max = 30,message = "Name is not valid")
    private String name;


 //   @Min(value = 0, message = "Age is not correct")
 //   @Max(value = 120,message = "Age is not valid")
    private int age;


 //   @NotEmpty(message = "Email should not be empty")
 //   @Email(message = "Email is not valid")
    private String email;

    public User() {
    }

    public User(int id, String name,int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}

