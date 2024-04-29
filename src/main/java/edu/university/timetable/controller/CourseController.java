package edu.university.timetable.controller;


import edu.university.timetable.model.Course;
import edu.university.timetable.repository.CourseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("")
    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable("id") int id) {
        return courseRepository.getCourseById(id);
    }

    @PostMapping("")
    public int addCourse(@RequestBody Course course) {
        return courseRepository.addCourse(course.getName(), course.getCoordinatorTeacher().getId(), course.getEcts());
    }
}
