package edu.university.timetable.repository;

import edu.university.timetable.model.AcademicTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AcademicTitleRepository {

    final JdbcTemplate jdbcTemplate;

    public AcademicTitleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<AcademicTitle> getAllAcademicTitles() {
        return jdbcTemplate.query("SELECT id, title, salary FROM academic_titles",
                BeanPropertyRowMapper.newInstance(AcademicTitle.class));
    }

    public AcademicTitle getAcademicTitleById(int id) {
        return jdbcTemplate.queryForObject("SELECT id, title, salary FROM academic_titles WHERE " +
                "id = ?", BeanPropertyRowMapper.newInstance(AcademicTitle.class), id);
    }
}
