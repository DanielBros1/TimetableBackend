package edu.university.timetable.controller;


import edu.university.timetable.model.Teacher;
import edu.university.timetable.repository.TeacherRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("")
    public List<Teacher> getAllTeachers() {
        return teacherRepository.getAllTeachers();
    }

    // get teacher by academic title
    @GetMapping("/academic-title/{id}")
    public List<Teacher> getTeachersByAcademicTitle(@PathVariable("id") int academicTitleId) {
        return teacherRepository.getTeachersByAcademicTitle(academicTitleId);
    }



}
