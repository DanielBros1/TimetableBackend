package edu.university.timetable.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@Entity(name = "academic_titles")
public class AcademicTitle {
    /**
     * CREATE table academic_titles
     * (
     *     id     INTEGER PRIMARY KEY AUTO_INCREMENT,
     *     title  VARCHAR(64) UNIQUE,
     *     salary DECIMAL(10, 2)
     * );
     */

    @Id
    private int id;

    @Getter
    private String title;

    @Getter
    private double salary;



}
