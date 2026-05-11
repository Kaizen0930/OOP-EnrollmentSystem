package org.example.service;

import org.example.model.Course;
import java.util.*;

public class CourseRegistration {
    public ArrayList<Course> courseList = new ArrayList<>();
    public Scanner scanner = new Scanner(System.in);

    public CourseRegistration() {}

    // Create
    public void addCourse(Course course) {
        courseList.add(course);
    }

    // Read
    public void displayAll() {
        System.out.println(courseList);
    }

    // Update
    public String updateCourse(Course course) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).courseID.equals(course.courseID)) {
                System.out.print("Enter course name: ");
                String name = scanner.nextLine();

                System.out.print("Enter program: ");
                String program = scanner.nextLine();

                courseList.set(i, new Course(course.courseID, name, program));
                return "Successfully updated";
            }
        }
        return "Course not found";
    }

    // Remove
    public String delete(Course course) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).courseID.equals(course.courseID)) {
                courseList.remove(i);
                return "Successfully deleted.";
            }
        }
        return "Error";
    }

    @Override
    public String toString() {
        return "CourseRegistration [Total Courses=" + courseList.size() + "]";
    }
}