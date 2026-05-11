package org.example.service;

import org.example.model.Course;
import org.example.model.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class CourseRegistrationTest {

    private CourseRegistration courseService;
    private Department dept;

    @BeforeEach
    void setup() {
        courseService = new CourseRegistration();
        dept = new Department("College of Computer Studies");
    }

    @Test
    void testAddCourse() {
        Course course = new Course("CS101", "Intro to Computing", 3);

        courseService.addCourse(dept, course);

        ArrayList<Course> courses = courseService.getAllCourses(dept);
        assertEquals(1, courses.size());
        assertEquals("CS101", courses.get(0).courseCode);
    }

    @Test
    void testAddDuplicateCourseIsIgnored() {
        Course course = new Course("CS101", "Intro to Computing", 3);

        courseService.addCourse(dept, course);
        courseService.addCourse(dept, course); // same object, should not duplicate

        assertEquals(1, courseService.getAllCourses(dept).size());
    }

    @Test
    void testUpdateCourse() {
        Course course = new Course("CS101", "Intro to Computing", 3);
        courseService.addCourse(dept, course);

        String result = courseService.updateCourse(dept, "CS101", "Java Programming", 4);

        assertEquals("Course updated successfully.", result);
        assertEquals("Java Programming", dept.courses.get(0).courseName);
        assertEquals(4, dept.courses.get(0).units);
    }

    @Test
    void testUpdateCourseNotFound() {
        String result = courseService.updateCourse(dept, "GHOST99", "Unknown", 0);

        assertEquals("Course not found.", result);
    }

    @Test
    void testRemoveCourse() {
        Course course = new Course("CS101", "Intro to Computing", 3);
        courseService.addCourse(dept, course);

        String result = courseService.removeCourse(dept, "CS101");

        assertEquals("Course removed successfully.", result);
        assertTrue(courseService.getAllCourses(dept).isEmpty());
    }

    @Test
    void testRemoveCourseNotFound() {
        String result = courseService.removeCourse(dept, "GHOST99");

        assertEquals("Course not found.", result);
    }

    @Test
    void testFullCourseFlow() {
        Course course = new Course("IT201", "Data Structures", 3);

        courseService.addCourse(dept, course);
        assertEquals(1, courseService.getAllCourses(dept).size());

        String updateMsg = courseService.updateCourse(dept, "IT201", "Algorithms", 4);
        assertEquals("Course updated successfully.", updateMsg);

        String removeMsg = courseService.removeCourse(dept, "IT201");
        assertEquals("Course removed successfully.", removeMsg);

        assertTrue(courseService.getAllCourses(dept).isEmpty());
    }
}