package edu.university.timetable.repository;

import edu.university.timetable.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository {

    // @Autowired - provides more fine-grained control over
    // where and how autowiring should be accomplished.
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> getAllPersons() {
        return jdbcTemplate.query("SELECT id, first_name, last_name, email, phone FROM people",
                BeanPropertyRowMapper.newInstance(Person.class));

    }

//    // add a new person
//    public int addPerson(Person person) {
//        return jdbcTemplate.update("INSERT INTO people (first_name, last_name, email, phone) VALUES (?, ?, ?, ?)",
//                person.getFirstName(), person.getLastName(), person.getEmail(), person.getPhone());
//    }

    // TODO: 28/04/2024 trigger - if one create a new student, a new person should be created
}
