package edu.university.timetable.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

/**
 * Annotation @Data is necessary to generate setters in this class which are used to set values
 * in the object of this class. Without setters, all objects fetched from the database will have fields with null values
 */
@Data
@Entity(name = "people")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Column(name = "first_name")
    private String firstName;

    @Getter
    @Column(name = "last_name")
    private String lastName;

    @Getter
    private String email;

    private String phone;

    private String birth_date;

    private String address;


}
