package com.example.demo.bean;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    private LocalDateTime createdDate;

    public Course() {
    }

    public Course(int id, String name, LocalDateTime lastUpdatedDate, LocalDateTime createdDate) {
        this.id = id;
        this.name = name;
        this.lastUpdatedDate = lastUpdatedDate;
        this.createdDate = createdDate;
    }

    public Course(String name) {
        this.name = name;
    }

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
