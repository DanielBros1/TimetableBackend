package edu.university.timetable.controller;


import edu.university.timetable.model.Teacher;
import edu.university.timetable.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("")
    public List<Teacher> getTeachersWithPersonDetails() {
        return teacherRepository.findTeachersWithPersonDetails();
    }

    // get teacher by academic title
    @GetMapping("/academic-title/{id}")
    public List<Teacher> getTeachersByAcademicTitle(@PathVariable("id") int academicTitleId) {
        return teacherRepository.findTeachersByAcademicTitle(academicTitleId);
    }


}
