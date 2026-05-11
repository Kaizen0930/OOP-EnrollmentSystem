package org.example.service;

import org.example.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentRegistrationTest {

    private StudentRegistration regService;

    @BeforeEach
    void setup() {
        regService = new StudentRegistration();
    }

    @Test
    void shouldAddStudentToList() {
        Student s = new Student(101, "Kiehl", "BSIT");

        regService.addStudent(s);

        assertEquals(1, regService.getAllStudents().size());
        assertEquals("Kiehl", regService.getAllStudents().get(0).name);
    }

    @Test
    void shouldRemoveStudentById() {
        Student s = new Student(101, "Kiehl", "BSIT");
        regService.addStudent(s);

        regService.removeStudent(101);

        assertTrue(regService.getAllStudents().isEmpty(), "The list should be empty after removal.");
    }
}