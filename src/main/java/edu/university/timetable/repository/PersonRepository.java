package edu.university.timetable.repository;

import edu.university.timetable.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> getAllPersons() {
        return jdbcTemplate.query("SELECT id, first_name, last_name, email, phone FROM people",
                BeanPropertyRowMapper.newInstance(Person.class));

    }


}
