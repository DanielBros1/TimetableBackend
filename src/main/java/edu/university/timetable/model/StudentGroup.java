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

//    @Column(name = "student_id")
//    private String studentId;
//
//    @Column(name = "group_id")
//    private int groupId;

    // one student can be in many groups
    // one group can have many students

    // many students to many groups
    @ManyToMany
    @JoinTable(
            name = "students_groups",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private List<Course> courses = new ArrayList<>();


}
