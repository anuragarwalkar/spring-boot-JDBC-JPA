package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private Long id;

    private String description;

    private String rating;

    // ToOne is always earger fetching
    @JsonBackReference
    @ManyToOne
    private Course course;

    public Review() {

    }

    public Review(String description, String rating) {
        this.description = description;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Review [description=" + description + ", id=" + id + ", rating=" + rating + "]";
    }

    public Review(Long id, String description, String rating) {
        this.id = id;
        this.description = description;
        this.rating = rating;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
