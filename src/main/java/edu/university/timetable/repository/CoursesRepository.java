package edu.university.timetable.repository;

import edu.university.timetable.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesRepository extends JpaRepository<Course, Integer> {

    @Query("SELECT c FROM courses c JOIN FETCH c.coordinatorTeacher")
    List<Course> getAllCourses();

    @Query("SELECT c FROM courses c JOIN FETCH c.coordinatorTeacher WHERE c.id = ?1")
    Course getCourseById(int id);
}

