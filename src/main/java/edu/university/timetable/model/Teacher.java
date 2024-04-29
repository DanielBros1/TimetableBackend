package edu.university.timetable.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "teachers")
public class Teacher {

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
