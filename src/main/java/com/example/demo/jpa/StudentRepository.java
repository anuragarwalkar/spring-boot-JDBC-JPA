package com.example.demo.jpa;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.example.demo.bean.Course;
import com.example.demo.bean.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    private EntityManager entityManager;

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public Student save(Student student) {

        if (student.getId() == null) {
            entityManager.persist(student);
        } else {
            entityManager.merge(student);
        }

        return student;
    }

    public void insertStudentAndCourse() {
        Student student = new Student("Ranga");
        Course course = new Course("Microservices in 100 steps");

        entityManager.persist(student);
        entityManager.persist(course);

        student.addCourse(course);
        course.addStudent(student);

        // Owning side
        entityManager.persist(student);
    }

}
