package com.example.demo.jdbc;

import java.util.List;

import com.example.demo.bean.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonJdbcDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // Select * from person table
    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper(Person.class));
    }
}
