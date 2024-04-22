package edu.university.timetable.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.hibernate.event.internal.OnUpdateVisitor;

@Data
@Entity(name = "courses")
public class Course {

    /**
     * CREATE table courses
     * (
     * id                     INTEGER PRIMARY KEY AUTO_INCREMENT,
     * name                   VARCHAR(64) NOT NULL,
     * coordinator_teacher_id INTEGER, # teacher_id (not person_id)
     * ects                   DECIMAL(3, 1),
     * CONSTRAINT course_coordinator_teacher_fk
     * FOREIGN KEY (coordinator_teacher_id) REFERENCES teachers (id)
     * ON UPDATE CASCADE ON DELETE NO ACTION
     * -- zmiana id nauczyciela w tabeli teachers zmieni coordinator_teacher_id w tabeli courses
     * );
     */

    @Id
    private int id;

    private String name;


    @ManyToOne // many courses to one teacher
    @JoinColumn(name = "coordinator_teacher_id", referencedColumnName = "id")
    private Teacher coordinatorTeacher;

    private double ects;
}
