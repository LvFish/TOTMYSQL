package com.lvfish.iotest;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private String email;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String toString() {
        return "name: " + name + " age: " + age + " email: " + email;
    }
}
