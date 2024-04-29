package edu.university.timetable.repository;


import edu.university.timetable.model.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentGroupRepository extends JpaRepository<StudentGroup, Integer> {


    @Query("SELECT sg FROM students_groups sg")
    List<StudentGroup> getAllStudentGroups();


    @Query("SELECT sg FROM students_groups sg WHERE sg.student.studentNumber = :studentNumber")
    List<StudentGroup> getStudentGroupsByStudentNumber(String studentNumber);

    // add a new student group
    @Query(value = "INSERT INTO students_groups (student_id, group_id) VALUES (:student_id, :group_id)", nativeQuery = true)
    void addStudentGroup(String student_id, int group_id);

}

