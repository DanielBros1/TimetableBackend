package edu.university.timetable.repository;

import edu.university.timetable.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>{

    @Query("SELECT s FROM students s JOIN FETCH s.person")
    List<Student> findStudentsWithPersonDetails();

    // Get student by student number
    @Query("SELECT s FROM students s WHERE s.studentNumber = ?1")
    Student findByStudentNumber(String studentNumber);
}