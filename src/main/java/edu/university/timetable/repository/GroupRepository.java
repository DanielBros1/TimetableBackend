package edu.university.timetable.repository;

import edu.university.timetable.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

    @Query("SELECT g FROM groups g JOIN FETCH g.course")
    List<Group> getAllGroups();

    @Query("SELECT g FROM groups g JOIN FETCH g.course WHERE g.id = ?1")
    Group getGroupById(int id);

    @Query("SELECT g FROM groups g JOIN FETCH g.course WHERE g.course.id = ?1")
    List<Group> getGroupByCourseId(int courseId);

    @Query(value = "INSERT INTO `groups` (course_id, teacher_id, group_number, date_started, date_finished, day_of_week, type) VALUES (:course, :teacher, :groupNumber, :dateStarted, :dateFinished, :dayOfWeek, :type)", nativeQuery = true)
    void addGroup(int course, int teacher, int groupNumber, String dateStarted, String dateFinished, String dayOfWeek, String type);
}
