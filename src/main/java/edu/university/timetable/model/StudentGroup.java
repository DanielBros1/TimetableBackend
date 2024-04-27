package edu.university.timetable.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "students_groups")
public class StudentGroup {

    /**
     *
     * CREATE table students_groups
     * (
     *     id         INTEGER PRIMARY KEY AUTO_INCREMENT,
     *     student_id VARCHAR(7) NOT NULL,
     *     group_id   INTEGER    NOT NULL,
     *     CONSTRAINT student_group_student_fk
     *         FOREIGN KEY (student_id) REFERENCES students (student_number)
     *             ON UPDATE CASCADE ON DELETE CASCADE,
     *     CONSTRAINT student_group_group_fk
     *         FOREIGN KEY (group_id) REFERENCES `groups` (id)
     *             ON UPDATE CASCADE ON DELETE CASCADE
     * );
     */

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
