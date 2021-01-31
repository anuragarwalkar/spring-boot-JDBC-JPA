package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.example.demo.bean.Person;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JPQLTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void jpql_basic() {
        List<Person> resultList = em.createQuery("Select p From Person p").getResultList();
        logger.info("Select p From Person p {}", resultList);
    }

    @Test
    public void jpql_typed() {
        TypedQuery<Person> query = em.createQuery("Select p from Person p", Person.class);
        List<Person> resultList = query.getResultList();

        logger.info("Select c from Course c {}", resultList);
    }

    @Test
    public void jpql_where() {
        TypedQuery<Person> query = em.createQuery("Select p from Person p where name like '%Anurag'", Person.class);

        List<Person> resultList = query.getResultList();

        logger.info("Select p From Person {}", resultList);
    }

}
