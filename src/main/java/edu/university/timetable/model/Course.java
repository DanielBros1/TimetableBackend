package edu.university.timetable.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "courses")
public class Course {

    @Id
    private int id;

    private String name;

    @ManyToOne // many courses to one teacher
    @JoinColumn(name = "coordinator_teacher_id", referencedColumnName = "id")
    private Teacher coordinatorTeacher;

    private double ects;
}
