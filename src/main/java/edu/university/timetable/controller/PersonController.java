package edu.university.timetable.controller;


import edu.university.timetable.model.Person;
import edu.university.timetable.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("")
    public List<Person> getAllPersons() {
        return personRepository.getAllPersons();
    }

}
