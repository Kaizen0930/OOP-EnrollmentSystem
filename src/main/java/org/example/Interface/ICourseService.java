package org.example.Interface;

import org.example.model.Course;

import java.util.ArrayList;

public interface ICourseService {

    void addCourse(Course course);

    ArrayList<Course> getAllCourses();

    String updateCourse(String courseID, String courseName, String program);

    String removeCourse(String courseID);
}
