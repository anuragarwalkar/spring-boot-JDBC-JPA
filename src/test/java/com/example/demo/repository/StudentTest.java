package com.example.demo.repository;

import javax.persistence.EntityManager;

import com.example.demo.bean.Student;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    @Test
    public void getStudentDetails() {
        Student aNewStudent = entityManager.find(Student.class, 112L);
        logger.info("funck {}", aNewStudent);
    }
}
