package edu.university.timetable.controller;

import edu.university.timetable.model.Student;
import edu.university.timetable.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("")
    public List<Student> getStudentsWithPersonDetails() {
        return studentRepository.getAllStudents();
    }

    @GetMapping("/{studentNumber}")
    public Student getStudentByStudentNumber(@PathVariable("studentNumber") String studentNumber) {
        return studentRepository.getStudentByStudentNumber(studentNumber);
    }
}
