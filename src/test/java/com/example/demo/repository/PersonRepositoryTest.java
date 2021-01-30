package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Date;

import com.example.demo.bean.Person;
import com.example.demo.jpa.PersonJpaRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository jpa;

	@BeforeEach
	void runBeforeAll() {
		logger.info("Running the tests...");
	}

	@Test
	void PersonFindById_basic() {
		Person person = jpa.findById(111);
		assertEquals("Anurag", person.getName());
	}

	@Test
	void deletePersonById_basic() {
		jpa.deleteById(112);
		assertNull(jpa.findById(112));
	}

	@Test
	void insertNewPerson_basic() {
		Person newPerson = new Person("Sameer", "Pune", new Date());
		Person savedPerson = jpa.insert(newPerson);

		assertEquals(savedPerson.getName(), newPerson.getName());
		assertEquals(savedPerson.getBirthDate(), newPerson.getBirthDate());
		assertEquals(savedPerson.getLocation(), newPerson.getLocation());
	}

}
