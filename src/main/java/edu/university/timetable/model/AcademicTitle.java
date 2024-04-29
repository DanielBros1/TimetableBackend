package edu.university.timetable.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;

@Data
@Entity(name = "academic_titles")
public class AcademicTitle {

    @Id
    private int id;

    @Getter
    private String title;

    @Getter
    private double salary;
}
