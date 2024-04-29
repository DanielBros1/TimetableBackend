package edu.university.timetable.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "students")
public class Student {

    @Id
    @Column(name = "student_number")
    private String studentNumber;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id", unique = true)
    private Person person;

    @Column(name = "date_enrolled")
    private String dateEnrolled;

    private String status;


}
