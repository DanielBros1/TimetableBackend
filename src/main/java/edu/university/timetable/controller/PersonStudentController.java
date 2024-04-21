package edu.university.timetable.controller;

import edu.university.timetable.model.Student;
import edu.university.timetable.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/person-students")
public class PersonStudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("")
    public List<Student> getStudentsWithPersonDetails() {
        return studentRepository.findStudentsWithPersonDetails();
    }
}
