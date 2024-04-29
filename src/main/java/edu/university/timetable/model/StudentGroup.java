package edu.university.timetable.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "students_groups")
public class StudentGroup {

    @Id
    private int id;

    // one student can exist in this table several times
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_number")
    private Student student;

    // one group can exist in this table several times
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;


}
