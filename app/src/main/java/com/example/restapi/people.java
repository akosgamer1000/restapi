package com.example.restapi;

public class people {
    int id;
    String FirstName;
    String LastName;
    int Age;
    String Email;
    String Phone;

    public people(int id, String email, String phone, int age, String lastName, String firstName) {
        this.id = id;
        Email = email;
        Phone = phone;
        Age = age;
        LastName = lastName;
        FirstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}