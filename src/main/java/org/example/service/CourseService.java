package org.example.service;

import org.example.model.Course;
import java.util.ArrayList;

public class CourseService {
    private ArrayList<Course> courseList = new ArrayList<>();

    public void addCourse(Course course) {
        courseList.add(course);
    }

    public void displayAll() {
        for (int i = 0; i < courseList.size(); i++) {
            System.out.println(courseList.get(i));
        }
    }

    public void updateCourse(Course updatedCourse) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getcourseID().equals(updatedCourse.getcourseID())) {
                courseList.set(i, updatedCourse);
                return;
            }
        }
    }

    public String deleteCourse(Course course) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getcourseID().equals(course.getcourseID())) {
                courseList.remove(i);
                return "Successfully Deleted Course";
            }
        }
        return "Error: Course not found";
    }
}