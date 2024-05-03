package edu.university.timetable.repository;

import edu.university.timetable.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testFindStudentsWithPersonDetails() {
        List<Student> students = studentRepository.getAllStudents();

        // Assert that the list is not empty
        assertNotNull(students);
    }

    @Test
    void testFindByStudentNumberReturnsNotNull() {
        String studentNumber = "1180013";
        Student student = studentRepository.getStudentByStudentNumber(studentNumber);

        assertNotNull(student);
    }
    @Test
    void testFindByStudentNumberReturnsCorrectStudent() {
        String studentNumber = "1180013";
        Student student = studentRepository.getStudentByStudentNumber(studentNumber);

        // print all student details
        System.out.println(student);

        assertEquals(studentNumber, student.getStudentNumber());
    }
}