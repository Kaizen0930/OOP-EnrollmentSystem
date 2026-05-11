package org.example.service;

import org.example.model.*;
import org.example.exception.SectionFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnrollmentRegistrationTest {

    private EnrollmentRegistration service;
    private Section testSection;

    @BeforeEach
    void init() {
        // Simple setup to keep tests clean
        service = new EnrollmentRegistration();
        testSection = new Section("IT-101", 1); // Capacity of only 1
    }

    @Test
    void checkSuccessfulEnrollment() throws SectionFullException {
        Student s1 = new Student(101, "Kiehl", "BSIT");

        service.enrollStudentInSection(s1, testSection);

        // Dull check: did the list size increase?
        assertEquals(1, testSection.students.size());
    }

    @Test
    void checkFullSectionError() throws SectionFullException {
        Student s1 = new Student(101, "Kiehl", "BSIT");
        Student s2 = new Student(102, "Alvarez", "BSIT");

        // Fill the only spot
        service.enrollStudentInSection(s1, testSection);

        // Attempting to add s2 should trigger the exception
        assertThrows(SectionFullException.class, () -> {
            service.enrollStudentInSection(s2, testSection);
        });
    }
}