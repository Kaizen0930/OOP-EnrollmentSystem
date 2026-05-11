package org.example.service;

import org.example.model.Instructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class InstructorRegistrationTest {

    private InstructorRegistration instructorService;

    @BeforeEach
    void setup() {
        instructorService = new InstructorRegistration();
    }

    @Test
    void shouldAddInstructorToList() {
        ArrayList<String> courses = new ArrayList<>();
        courses.add("CS101");
        Instructor instructor = new Instructor(1, "Dr. Santos", courses);

        instructorService.addInstructor(instructor);

        assertEquals(1, instructorService.getAllInstructors().size());
        assertEquals("Dr. Santos", instructorService.getAllInstructors().get(0).name);
    }

    @Test
    void shouldNotAddDuplicateInstructorId() {
        ArrayList<String> courses = new ArrayList<>();
        courses.add("CS101");
        Instructor i1 = new Instructor(1, "Dr. Santos", courses);
        Instructor i2 = new Instructor(1, "Dr. Reyes", courses); // same ID

        instructorService.addInstructor(i1);
        instructorService.addInstructor(i2);

        assertEquals(1, instructorService.getAllInstructors().size());
    }

    @Test
    void shouldReturnAllInstructors() {
        ArrayList<String> c1 = new ArrayList<>(); c1.add("CS101");
        ArrayList<String> c2 = new ArrayList<>(); c2.add("IT201");

        instructorService.addInstructor(new Instructor(1, "Dr. Santos", c1));
        instructorService.addInstructor(new Instructor(2, "Dr. Reyes", c2));

        assertEquals(2, instructorService.getAllInstructors().size());
    }

    @Test
    void shouldUpdateInstructorSuccessfully() {
        ArrayList<String> courses = new ArrayList<>();
        courses.add("CS101");
        instructorService.addInstructor(new Instructor(1, "Dr. Santos", courses));

        ArrayList<String> newCourses = new ArrayList<>();
        newCourses.add("IT301");
        String result = instructorService.updateInstructor(1, "Dr. Santos Jr.", newCourses);

        assertEquals("Instructor updated successfully.", result);
        assertEquals("Dr. Santos Jr.", instructorService.getAllInstructors().get(0).name);
        assertEquals("IT301", instructorService.getAllInstructors().get(0).courses.get(0));
    }

    @Test
    void shouldReturnNotFoundWhenUpdatingMissingInstructor() {
        String result = instructorService.updateInstructor(999, "Ghost", new ArrayList<>());

        assertEquals("Instructor not found.", result);
    }

    @Test
    void shouldRemoveInstructorById() {
        ArrayList<String> courses = new ArrayList<>();
        courses.add("CS101");
        instructorService.addInstructor(new Instructor(1, "Dr. Santos", courses));

        String result = instructorService.removeInstructor(1);

        assertEquals("Instructor removed successfully.", result);
        assertTrue(instructorService.getAllInstructors().isEmpty());
    }

    @Test
    void shouldReturnNotFoundWhenRemovingMissingInstructor() {
        String result = instructorService.removeInstructor(999);

        assertEquals("Instructor not found.", result);
    }

    @Test
    void shouldReturnInstructorDetails() {
        ArrayList<String> courses = new ArrayList<>();
        courses.add("CS101");
        Instructor instructor = new Instructor(1, "Dr. Santos", courses);
        instructorService.addInstructor(instructor);

        String details = instructorService.getInstructorDetails(1);

        assertEquals(instructor.toString(), details);
    }

    @Test
    void shouldReturnNotFoundForMissingInstructorDetails() {
        String result = instructorService.getInstructorDetails(999);

        assertEquals("Instructor not found.", result);
    }
}