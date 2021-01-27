package com.example.demo;

import java.util.Date;

import com.example.demo.bean.Person;
import com.example.demo.jdbc.PersonJdbcDAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

	@Autowired
	PersonJdbcDAO dao;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users ->{}", dao.findAll());
		logger.info("find all user ->{}", dao.findById(1));
		logger.info("find a user ->{}", dao.findByName("anurag"));
		logger.info("deleted a user ->{}", dao.deleteById(1));
		logger.info("update a user ->{}", dao.update(new Person(1, "aaa", "sinhagad", new Date())));
		logger.info("create a user ->{}", dao.insert(new Person("saurabh", "sinhagad", new Date())));

	};

}
