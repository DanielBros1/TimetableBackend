package edu.university.timetable.repository;

import edu.university.timetable.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    @Query("SELECT t FROM teachers t JOIN FETCH t.person")
    List<Teacher> findTeachersWithPersonDetails();

    // Select teacher by academic title
    @Query("SELECT t FROM teachers t JOIN FETCH t.person JOIN FETCH t.academicTitle WHERE t.academicTitle.id = ?1")
    List<Teacher> findTeachersByAcademicTitle(int academicTitleId);
}
