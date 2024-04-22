package edu.university.timetable.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Data
@Entity(name = "teachers")
public class Teacher {

    /**
     * CREATE table teachers
     * (
     *     id                INTEGER PRIMARY KEY AUTO_INCREMENT,
     *     person_id         INTEGER UNIQUE NOT NULL,
     *     date_hired        DATE,
     *     academic_title_id INTEGER,
     *     CONSTRAINT teacher_person_id_fk -- constraint name (is optional)
     *         FOREIGN KEY (person_id) REFERENCES people (id)
     *             ON UPDATE CASCADE ON DELETE RESTRICT,
     *     CONSTRAINT teacher_academic_title_fk
     *         FOREIGN KEY (academic_title_id) REFERENCES academic_titles (id)
     *             ON UPDATE CASCADE ON DELETE NO ACTION
     *     -- zmiana id tytułu akademickiego zmieni academic_title_id w tabeli teachers
     * );
     */

    @Id
    private int id;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id", unique = true)
    private Person person;

    @Column(name = "date_hired")
    private String dateHired;

    @ManyToOne
    @JoinColumn(name = "academic_title_id", referencedColumnName = "id")
    private AcademicTitle academicTitle;

}
