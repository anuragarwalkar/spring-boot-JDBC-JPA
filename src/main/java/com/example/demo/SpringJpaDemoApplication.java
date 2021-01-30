package com.example.demo;

import java.util.Date;

import com.example.demo.bean.Person;
import com.example.demo.jpa.PersonJpaRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaDemoApplication implements CommandLineRunner {

	@Autowired
	PersonJpaRepository jpa;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Find by id ={}", jpa.findById(111));
		logger.info("Create new ={}", jpa.insert(new Person("Anurag", "Banalore", new Date())));
		logger.info("Find by id and update  ={}", jpa.update(new Person(111, "Anurag", "Banalore", new Date())));
		logger.info("find all ={}", jpa.findAll());
		jpa.deleteById(113);
	}

}
