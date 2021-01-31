package com.example.demo.jpa;

import java.util.Date;
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

    // Important ----
    // As we have enabled @transcational the code in this method is a
    // traction hence it will update the location
    public void playWithEntityManger() {
        Person newPerson = new Person("Inspiron", "local", new Date());
        entityManager.persist(newPerson); // It will run the tranctional mode
        // entityManager.merge(newPerson);
        newPerson.setLocation("localhost");
        entityManager.flush(); // To update database till this step

        Person aNewPerson = new Person("Latitude", "local", new Date());
        entityManager.persist(aNewPerson);
        entityManager.flush();

        newPerson.setName("Inspiron 3560");

        Person swapnil = new Person("Swapnil", "kasarwadi", new Date());
        entityManager.persist(swapnil);
        entityManager.flush();

        // entityManager.clear();

    }

}
