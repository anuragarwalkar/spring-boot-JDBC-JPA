package com.example.demo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.example.demo.bean.Course;
import com.example.demo.bean.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager em;

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public Course save(Course couse) {

        if (couse.getId() == null) {
            em.persist(couse);
        } else {
            em.merge(couse);
        }

        return couse;
    }

    // public void addReviewForCourse(Long courseId) {
    // Course course = this.findById(courseId);

    // Review reviewOne = new Review("hello nehu", "excellent");
    // Review reviewTwo = new Review("hello nehu", "god");

    // reviewOne.setCourse(course);
    // reviewTwo.setCourse(course);

    // course.setReview(reviewOne);
    // course.setReview(reviewTwo);

    // em.persist(reviewOne);
    // em.persist(reviewTwo);

    // }

    public void addReviewForCourse(Long courseId, List<Review> reviews) {
        Course course = this.findById(courseId);

        for (Review review : reviews) {
            review.setCourse(course);
            course.setReview(review);

            em.persist(review);
        }

    }
}
