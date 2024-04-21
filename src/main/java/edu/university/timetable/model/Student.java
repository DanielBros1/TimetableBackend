package edu.university.timetable.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "students")
public class Student {

    /**
     * CREATE table students
     * (
     *     student_number VARCHAR(7) PRIMARY KEY UNIQUE NOT NULL,
     *     person_id      INTEGER UNIQUE                NOT NULL,
     *     date_enrolled  DATE,
     *     status         ENUM ('active', 'graduated', 'inactive'),
     *     CONSTRAINT student_person_id_fk
     *         FOREIGN KEY (person_id) REFERENCES people (id)
     *             ON UPDATE CASCADE ON DELETE RESTRICT -- najpierw usuwamy studenta, potem osobę.
     *     -- Usuniecie osoby, do której jest przypisany student, jest niemożliwe
     * );
     */

    @Id
    private String studentNumber;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id", unique = true)
    private Person person;

    @Column(name = "date_enrolled")
    private String dateEnrolled;

    private String status;



}
