package edu.university.timetable.repository;

import edu.university.timetable.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Group> getAllGroups() {
        return jdbcTemplate.query("SELECT id, course_id, teacher_id, group_number, date_started, date_finished, day_of_week, type FROM groups",
                BeanPropertyRowMapper.newInstance(Group.class));
    }

    public Group getGroupById(int id) {
        return jdbcTemplate.queryForObject("SELECT id, course_id, teacher_id, group_number, date_started, date_finished, day_of_week, type FROM groups WHERE " +
                "id = ?", BeanPropertyRowMapper.newInstance(Group.class), id);
    }


}
