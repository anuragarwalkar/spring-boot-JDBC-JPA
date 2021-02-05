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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

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
		Person person = jpa.findById(111L);
		assertEquals("Anurag", person.getName());
	}

	@Test
	@Transactional
	void PersonFindById_basicFirstLevelCacheDemo() {
		Person person = jpa.findById(111L);
		logger.info("First person {}", person);
		assertEquals("anurag", person.getName());

		Person person1 = jpa.findById(111L);
		logger.info("Second person {}", person1);
		assertEquals("anurag", person1.getName());
	}

	@Test
	@DirtiesContext // Dry Run the test (It will delte the row and after runing it will restore)
	void deletePersonById_basic() {
		jpa.deleteById(112L);
		assertNull(jpa.findById(112L));
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
