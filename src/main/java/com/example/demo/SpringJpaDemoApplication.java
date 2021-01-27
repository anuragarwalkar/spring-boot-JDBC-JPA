package com.example.demo;

import java.util.Date;

import com.example.demo.bean.Person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaDemoApplication implements CommandLineRunner {

	@Autowired
	PersonJdbcDAO dao;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	};

}
