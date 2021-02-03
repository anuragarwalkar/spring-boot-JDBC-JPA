package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.example.demo.bean.Course;
import com.example.demo.bean.Person;
import com.example.demo.bean.Review;
import com.example.demo.bean.Student;
import com.example.demo.jpa.CourseRepository;
import com.example.demo.jpa.PersonJpaRepository;
import com.example.demo.jpa.StudentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaDemoApplication implements CommandLineRunner {

	@Autowired
	PersonJpaRepository personJpaRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	EntityManager em;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// logger.info("Find by id ={}", jpa.findById(111L));
		// logger.info("Create new ={}", jpa.insert(new Person("Anurag", "Banalore", new
		// Date())));
		// logger.info("Find by id and update ={}", jpa.update(new Person(111L,
		// "Anurag", "Banalore", new Date())));
		// logger.info("find all ={}", jpa.findAll());
		// jpa.deleteById(113L);
		// jpa.playWithEntityManger();
		List<Review> reviews = new ArrayList<>();

		reviews.add(new Review("hello nehu", "excellent"));
		reviews.add(new Review("hello nehu", "god"));

		courseRepository.addReviewForCourse(111L, reviews);
		studentRepository.insertStudentAndCourse();
		// Course newCourse = courseRepository.findById(111L);

		// TypedQuery<Course> createQuery = em.createQuery("select c from Course c where
		// c.students is empty");
		// TypedQuery<Course> createQuery = em.createQuery("select c from Course c where
		// size(c.students) > 2",
		// Course.class);
		TypedQuery<Student> createQuery = em
				.createQuery("Select s from Student s where s.passport.number like '%0743%'", Student.class);
		// List<Course> resultList = createQuery.getResultList();
		List<Student> resultList = createQuery.getResultList();

		logger.info("Result {}", resultList);

	}

}
