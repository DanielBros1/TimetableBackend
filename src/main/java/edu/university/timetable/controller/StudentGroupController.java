package edu.university.timetable.controller;


import edu.university.timetable.model.StudentGroup;
import edu.university.timetable.repository.StudentGroupRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentGroups")
public class StudentGroupController {

    private final StudentGroupRepository studentGroupRepository;

    public StudentGroupController(StudentGroupRepository studentGroupRepository) {
        this.studentGroupRepository = studentGroupRepository;
    }

    @GetMapping("")
    public List<StudentGroup> getAllStudentGroups() {
        return studentGroupRepository.getAllStudentGroups();
    }

    @GetMapping("/student/{studentNumber}")
    public List<StudentGroup> getStudentGroupsByStudentNumber(@PathVariable String studentNumber) {
        return studentGroupRepository.getStudentGroupsByStudentNumber(studentNumber);
    }

    @PostMapping("")
    public void addStudentGroup(@RequestBody StudentGroup studentGroup) {
        studentGroupRepository.addStudentGroup(studentGroup.getStudent().getStudentNumber(), studentGroup.getGroup().getId());
    }
}
