package com.example.demo.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String location;
    private Date birthDate;

    public Person(int id, String name, String location, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.location = location;
    }

    public Person(String name, String location, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.location = location;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "\nPerson [birthDate=" + birthDate + ", id=" + id + ", location=" + location + ", name=" + name + "]";
    }

}
