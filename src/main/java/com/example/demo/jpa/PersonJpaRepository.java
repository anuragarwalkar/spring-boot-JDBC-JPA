package com.example.demo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.example.demo.bean.Person;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PersonJpaRepository {

    // Connect to database
    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }
}
