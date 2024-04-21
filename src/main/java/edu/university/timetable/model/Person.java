package edu.university.timetable.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

/**
 * Annotation @Data is necessary to generate setters in this class which are used to set values
 * in the object of this class. Without setters, all objects fetched from the database will have fields with null values
 */
@Getter
@Data
@Entity(name = "people")
public class Person {

    /**
     * CREATE table people
     * (
     * id         INTEGER PRIMARY KEY AUTO_INCREMENT,
     * first_name VARCHAR(64),
     * last_name  VARCHAR(64),
     * email      VARCHAR(64),
     * phone      VARCHAR(11),
     * birth_date DATE,
     * address    VARCHAR(64)
     * );
     */

    // Constructor
    public Person() {
    }

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Column(name = "first_name")
    private String firstName;

    @Getter
    private String lastName;

    @Getter
    private String email;

    private String phone;

    private String birth_date;

    private String address;


}
