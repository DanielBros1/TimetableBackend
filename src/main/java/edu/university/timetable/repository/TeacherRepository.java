package edu.university.timetable.repository;

import edu.university.timetable.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    @Query("SELECT t FROM teachers t JOIN FETCH t.person")
    List<Teacher> getAllTeachers();

    // Select teacher by academic title
    @Query("SELECT t FROM teachers t JOIN FETCH t.person JOIN FETCH t.academicTitle WHERE t.academicTitle.id = ?1")
    List<Teacher> getTeachersByAcademicTitle(int academicTitleId);
}
