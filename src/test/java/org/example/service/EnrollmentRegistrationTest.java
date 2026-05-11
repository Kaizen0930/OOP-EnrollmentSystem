package org.example.service;

import org.example.model.*;
import org.example.exception.SectionFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnrollmentRegistrationTest {

    private EnrollmentRegistration service;
    private Section testSection;
    private Student student1;
    private Student student2;

    @BeforeEach
    void init() {
        service = new EnrollmentRegistration();
        testSection = new Section("IT-101", 2);
        student1 = new Student(101, "Kiehl", "BSIT", 20000.00);
        student2 = new Student(102, "Alvarez", "BSIT", 20000.00);
    }

    @Test
    void checkSuccessfulEnrollment() throws SectionFullException {
        boolean result = service.enrollStudentInSection(student1, testSection);

        assertTrue(result);
        assertEquals(1, testSection.students.size());
        assertEquals("Kiehl", testSection.students.get(0).name);
    }

    @Test
    void checkFullSectionThrowsException() throws SectionFullException {
        Section smallSection = new Section("IT-102", 1);
        service.enrollStudentInSection(student1, smallSection);

        assertThrows(SectionFullException.class, () ->
                service.enrollStudentInSection(student2, smallSection)
        );
    }

    @Test
    void checkFullSectionExceptionMessage() throws SectionFullException {
        Section smallSection = new Section("IT-102", 1);
        service.enrollStudentInSection(student1, smallSection);

        SectionFullException ex = assertThrows(SectionFullException.class, () ->
                service.enrollStudentInSection(student2, smallSection)
        );
        assertTrue(ex.getMessage().contains("IT-102"));
        assertTrue(ex.getMessage().contains("max capacity"));
    }

    @Test
    void checkDuplicateEnrollmentPrevented() throws SectionFullException {
        service.enrollStudentInSection(student1, testSection);

        boolean result = service.enrollStudentInSection(student1, testSection);

        assertFalse(result);
        assertEquals(1, testSection.students.size()); // still only 1 student
    }

    @Test
    void checkMultipleStudentsEnrollSuccessfully() throws SectionFullException {
        service.enrollStudentInSection(student1, testSection);
        service.enrollStudentInSection(student2, testSection);

        assertEquals(2, testSection.students.size());
    }

    @Test
    void checkNullStudentReturnsFalse() throws SectionFullException {
        boolean result = service.enrollStudentInSection(null, testSection);

        assertFalse(result);
        assertEquals(0, testSection.students.size());
    }

    @Test
    void checkNullSectionReturnsFalse() throws SectionFullException {
        boolean result = service.enrollStudentInSection(student1, null);

        assertFalse(result);
    }

    @Test
    void checkAcademicScholarshipApplied() {
        String result = service.applyScholarship(student1, "ACADEMIC");

        assertEquals("ACADEMIC", student1.scholarshipType);
        assertEquals(10000.00, student1.tuitionFee, 0.001);
        assertTrue(result.contains("ACADEMIC"));
        assertTrue(result.contains("50%"));
    }

    @Test
    void checkAthleticScholarshipApplied() {
        String result = service.applyScholarship(student1, "ATHLETIC");

        assertEquals("ATHLETIC", student1.scholarshipType);
        assertEquals(14000.00, student1.tuitionFee, 0.001);
        assertTrue(result.contains("ATHLETIC"));
        assertTrue(result.contains("30%"));
    }

    @Test
    void checkFinancialAidScholarshipApplied() {
        String result = service.applyScholarship(student1, "FINANCIAL_AID");

        assertEquals("FINANCIAL_AID", student1.scholarshipType);
        assertEquals(5000.00, student1.tuitionFee, 0.001);
        assertTrue(result.contains("FINANCIAL_AID"));
        assertTrue(result.contains("75%"));
    }

    @Test
    void checkScholarshipTypeIsCaseInsensitive() {
        String result = service.applyScholarship(student1, "academic");

        assertEquals("ACADEMIC", student1.scholarshipType);
        assertFalse(result.contains("failed"));
    }

    @Test
    void checkInvalidScholarshipTypeRejected() {
        String result = service.applyScholarship(student1, "FULL_RIDE");

        assertNull(student1.scholarshipType);
        assertEquals(20000.00, student1.tuitionFee, 0.001); // no change
        assertTrue(result.contains("failed"));
        assertTrue(result.contains("Invalid"));
    }

    @Test
    void checkNullScholarshipTypeRejected() {
        String result = service.applyScholarship(student1, null);

        assertNull(student1.scholarshipType);
        assertTrue(result.contains("failed"));
    }

    @Test
    void checkEmptyScholarshipTypeRejected() {
        String result = service.applyScholarship(student1, "   ");

        assertNull(student1.scholarshipType);
        assertTrue(result.contains("failed"));
    }

    @Test
    void checkDuplicateScholarshipPrevented() {
        service.applyScholarship(student1, "ACADEMIC");
        double feeAfterFirst = student1.tuitionFee;

        String result = service.applyScholarship(student1, "ACADEMIC");

        assertEquals(feeAfterFirst, student1.tuitionFee, 0.001); // no second deduction
        assertTrue(result.contains("already has"));
    }

    @Test
    void checkScholarshipReplacedWithDifferentType() {
        service.applyScholarship(student1, "ATHLETIC"); // 30% off → 14000
        String result = service.applyScholarship(student1, "ACADEMIC"); // 50% off 14000 → 7000

        assertEquals("ACADEMIC", student1.scholarshipType);
        assertEquals(7000.00, student1.tuitionFee, 0.001);
        assertTrue(result.contains("Replaced previous scholarship"));
    }

    @Test
    void checkScholarshipFailsWithZeroTuition() {
        Student broke = new Student(200, "Libre", "BSCS"); // tuitionFee defaults to 0

        String result = service.applyScholarship(broke, "ACADEMIC");

        assertNull(broke.scholarshipType);
        assertTrue(result.contains("no tuition fee"));
    }

    @Test
    void checkNullStudentScholarshipRejected() {
        String result = service.applyScholarship(null, "ACADEMIC");

        assertTrue(result.contains("failed"));
    }
}