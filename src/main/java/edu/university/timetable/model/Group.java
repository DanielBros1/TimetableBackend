package edu.university.timetable.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "groups")
public class Group {
    /**
     *
     * CREATE table `groups`
     * (
     *     id            INTEGER PRIMARY KEY AUTO_INCREMENT,
     *     course_id     INTEGER NOT NULL,
     *     teacher_id    INTEGER,
     *     group_number  INTEGER,
     *     # Started and finished time ONLY HH:MM (without date)
     *     date_started  TIME,
     *     date_finished TIME,
     *     day_of_week   ENUM ('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'),
     *     type          ENUM ('lecture', 'class', 'lab'),
     *     CONSTRAINT group_course_fk
     *         FOREIGN KEY (course_id) REFERENCES courses (id)
     *             ON UPDATE CASCADE ON DELETE CASCADE,  -- usunięcie kursu usunie grupę
     * <p>
     *     CONSTRAINT group_teacher_fk
     *         FOREIGN KEY (teacher_id) REFERENCES teachers (id)
     *             ON UPDATE CASCADE ON DELETE NO ACTION -- usuniecie nauczyciela nie usunie grupy
     * );
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


   @Column(name = "course_id")
    private int courseId;


   @Column(name = "teacher_id")
    private int teacherId;

   @Column(name = "group_number")
    private int groupNumber;

   @Column(name = "date_started")
    private String dateStarted;

   @Column(name = "date_finished")
    private String dateFinished;

   @Column(name = "day_of_week")
    private String dayOfWeek;

    private String type;

}
