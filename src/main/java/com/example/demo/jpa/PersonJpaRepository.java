package com.example.demo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

    public List<Person> findAll() {
        TypedQuery<Person> createNamedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return createNamedQuery.getResultList();
    }

    public Person update(Person person) {
        return entityManager.merge(person);
    }

    public Person insert(Person person) {
        return entityManager.merge(person);
    }

    public void deleteById(int id) {
        Person person = this.findById(id);
        entityManager.remove(person);
    }
}
