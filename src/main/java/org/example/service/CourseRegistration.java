package org.example.service;

import org.example.Interface.ICourseService;
import org.example.model.Course;
import java.util.ArrayList;

public class CourseRegistration implements ICourseService {
    public ArrayList<Course> courseList = new ArrayList<>();

    public CourseRegistration() {}

    @Override
    public void addCourse(Course course) {
        for (Course c : courseList) {
            if (c.courseID.equals(course.courseID)) {
                System.out.println("Duplicate course ID.");
                return;
            }
        }
        courseList.add(course);
        System.out.println("Course added successfully.");
    }

    @Override
    public ArrayList<Course> getAllCourses() {
        return courseList;
    }

    @Override
    public String updateCourse(String courseID, String courseName, String program) {
        for (Course c : courseList) {
            if (c.courseID.equals(courseID)) {
                c.courseName = courseName;
                c.program = program;
                return "Course updated successfully.";
            }
        }
        return "Course not found.";
    }

    @Override
    public String removeCourse(String courseID) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).courseID.equals(courseID)) {
                courseList.remove(i);
                return "Course removed successfully.";
            }
        }
        return "Course not found.";
    }
}