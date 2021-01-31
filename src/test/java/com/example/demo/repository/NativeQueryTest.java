package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.example.demo.bean.Person;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NativeQueryTest {

    EntityManager entityManager;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void getPersons() {
        Query query = entityManager.createNativeQuery("Select * From Course", Person.class);
        List<Person> resultList = query.getResultList();

        logger.info("List of person {}", resultList);
    }
}
