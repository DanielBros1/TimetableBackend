package edu.university.timetable.controller;


import edu.university.timetable.model.AcademicTitle;
import edu.university.timetable.repository.AcademicTitleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/academicTitles")
public class AcademicTitleController {

    private final AcademicTitleRepository academicTitleRepository;

    public AcademicTitleController(AcademicTitleRepository academicTitleRepository) {
        this.academicTitleRepository = academicTitleRepository;
    }

    @GetMapping("")
    public List<AcademicTitle> getAllAcademicTitles() {
        return academicTitleRepository.getAllAcademicTitles();
    }

    @GetMapping("/{id}")
    public AcademicTitle getAcademicTitleById(@PathVariable("id") int id) {
        return academicTitleRepository.getAcademicTitleById(id);
    }
}
