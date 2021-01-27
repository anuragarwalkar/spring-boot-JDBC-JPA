package com.example.demo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.example.demo.bean.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PersonJdbcDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthDate(rs.getTimestamp("birth_date"));

            return person;
        }

    }

    // Select * from person table
    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] { id },
                new PersonRowMapper());
    }

    public List<Map<String, Object>> findByName(String name) {
        return jdbcTemplate.queryForList("select * from person where name=?", name);
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from person where id=?", new Object[] { id });
    }

    public int insert(Person person) {
        return jdbcTemplate.update("insert into person (name, location, birth_date) values(?, ?, ?)", new Object[] {
                person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()) });
    }

    public int update(Person person) {
        return jdbcTemplate.update("update person set name = ?, location = ?, birth_date = ? where id=?",
                new Object[] { person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()),
                        person.getId() });
    }
}
