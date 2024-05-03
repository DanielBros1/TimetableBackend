package edu.university.timetable.controller;

import edu.university.timetable.model.Student;
import edu.university.timetable.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentRepository studentRepository;

    @Test
    void testGetStudentsWithPersonDetails() throws Exception {
        Student student = new Student();
        student.setStudentNumber("1180005");
        when(studentRepository.getAllStudents()).thenReturn(Collections.singletonList(student));

        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].studentNumber").value("1180005"));
    }

    @Test
    void testGetStudentStatus() throws Exception {
        Student student = new Student();
        student.setStudentNumber("1180005");
        student.setStatus("active");
        when(studentRepository.getAllStudents()).thenReturn(Collections.singletonList(student));

        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].status").value("active"));
    }

    @Test
    void testGetStudentByStudentNumber() throws Exception {
        Student student = new Student();
        student.setStudentNumber("123");
        when(studentRepository.getStudentByStudentNumber("123")).thenReturn(student);

        mockMvc.perform(get("/students/123"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.studentNumber").value("123"));
    }
}