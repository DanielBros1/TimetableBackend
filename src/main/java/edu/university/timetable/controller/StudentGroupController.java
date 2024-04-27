package edu.university.timetable.controller;


import edu.university.timetable.model.StudentGroup;
import edu.university.timetable.repository.StudentGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/studentGroups")
public class StudentGroupController {

    @Autowired
    private StudentGroupRepository studentGroupRepository;


    @GetMapping("")
    public List<StudentGroup> getAllStudentGroups() {
        return studentGroupRepository.getAllStudentGroups();
    }
}
