package edu.university.timetable.repository;

import edu.university.timetable.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
//public class GroupRepository {
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    public List<Group> getAllGroups() {
//        return jdbcTemplate.query("SELECT id, course_id, teacher_id, group_number, date_started, date_finished, day_of_week, type FROM `groups`",
//                BeanPropertyRowMapper.newInstance(Group.class));
//    }
//
//    public Group getGroupById(int id) {
//        return jdbcTemplate.queryForObject("SELECT id, course_id, teacher_id, group_number, date_started, date_finished, day_of_week, type FROM `groups` WHERE " +
//                "id = ?", BeanPropertyRowMapper.newInstance(Group.class), id);
//    }
//
//    public List<Group> getGroupByCourseId(int courseId) {
//        return jdbcTemplate.query("SELECT id, course_id, teacher_id, group_number, date_started, date_finished, day_of_week, type FROM `groups` WHERE " +
//                "course_id = ?", BeanPropertyRowMapper.newInstance(Group.class), courseId);
//    }
//
//    // print
//
//
//}

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

    @Query("SELECT g FROM groups g JOIN FETCH g.course")
    List<Group> getAllGroups();

    @Query("SELECT g FROM groups g JOIN FETCH g.course WHERE g.id = ?1")
    Group getGroupById(int id);

    @Query("SELECT g FROM groups g JOIN FETCH g.course WHERE g.course.id = ?1")
    List<Group> getGroupByCourseId(int courseId);
}
