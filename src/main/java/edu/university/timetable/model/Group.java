package edu.university.timetable.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

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
