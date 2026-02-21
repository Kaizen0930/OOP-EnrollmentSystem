package org.example.service;

import org.example.model.Course;
import java.util.ArrayList;

public class CourseService {
    private ArrayList<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displayAll() {
        for (Course c : courses) {
            System.out.println(c);
        }
    }
}