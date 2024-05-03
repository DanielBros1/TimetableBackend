package edu.university.timetable.repository;

import edu.university.timetable.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query("SELECT c FROM courses c JOIN FETCH c.coordinatorTeacher")
    List<Course> getAllCourses();

    @Query("SELECT c FROM courses c JOIN FETCH c.coordinatorTeacher WHERE c.id = ?1")
    Course getCourseById(int id);

    @Query(value = "INSERT INTO courses (name, coordinator_teacher_id, ects) VALUES (:name, :coordinator_teacher_id, :ects)", nativeQuery = true)
    void addCourse(String name, int coordinator_teacher_id, double ects);

}
