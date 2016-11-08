package com.example.suryasolanki.databaseexample;

/**
 * Created by surya.solanki on 11/8/2016.
 */

public class Person {

    int id;
    String name;
    String phone_num;
    String email;
    String city;
    String street;

    public Person(int id, String name, String phone_num, String email, String city, String street) {
        this.id = id;
        this.name = name;
        this.phone_num = phone_num;
        this.email = email;
        this.city = city;
        this.street = street;
    }

    public Person(String name, String phone_num, String email, String city, String street) {
        this.name = name;
        this.phone_num = phone_num;
        this.email = email;
        this.city = city;
        this.street = street;
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

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
