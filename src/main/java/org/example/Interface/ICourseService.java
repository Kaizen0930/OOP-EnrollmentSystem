package org.example.Interface;

import org.example.model.Course;
import org.example.model.Department;
import java.util.ArrayList;

public interface ICourseService {
    void addCourse(Department dept, Course course);

    void displayCourses(Department dept);

    ArrayList<Course> getAllCourses(Department dept);

    String updateCourse(Department dept, String code, String newName, int newUnits);

    String removeCourse(Department dept, String code);
}