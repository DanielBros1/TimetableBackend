package edu.university.timetable.repository;


import edu.university.timetable.model.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentGroupRepository extends JpaRepository<StudentGroup, Integer> {

    @Query("SELECT sg FROM students_groups sg JOIN FETCH sg.courses")
            List<StudentGroup> getAllStudentGroups();
}
