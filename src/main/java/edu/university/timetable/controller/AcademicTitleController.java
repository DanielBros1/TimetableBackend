package edu.university.timetable.controller;


import edu.university.timetable.model.AcademicTitle;
import edu.university.timetable.repository.AcademicTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/academic_titles")
public class AcademicTitleController {

    @Autowired
    private AcademicTitleRepository academicTitleRepository;

    @GetMapping("")
    public List<AcademicTitle> getAllAcademicTitles() {
        return academicTitleRepository.getAllAcademicTitles();
    }

    @GetMapping("/{id}")
    public AcademicTitle getAcademicTitleById(@PathVariable("id") int id) {
        return academicTitleRepository.getAcademicTitleById(id);
    }
}
