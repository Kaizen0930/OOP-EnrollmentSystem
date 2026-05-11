package org.example.service;

import org.example.Interface.ICourseService;
import org.example.model.Course;
import org.example.model.Department;
import java.util.ArrayList;

public class CourseRegistration implements ICourseService {

    @Override
    public void addCourse(Department dept, Course course) {
        if (dept.courses != null && !dept.courses.contains(course)) {
            dept.courses.add(course);
            System.out.println("Course added successfully.");
        }
    }

    @Override
    public ArrayList<Course> getAllCourses(Department dept) {
        return (ArrayList<Course>) dept.courses;
    }

    @Override
    public String updateCourse(Department dept, String code, String newName, int newUnits) {
        for (Course c : dept.courses) {
            if (c.courseCode.equals(code)) {
                c.courseName = newName;
                c.units = newUnits;
                return "Course updated successfully.";
            }
        }
        return "Course not found.";
    }

    @Override
    public String removeCourse(Department dept, String code) {
        for (int i = 0; i < dept.courses.size(); i++) {
            if (dept.courses.get(i).courseCode.equals(code)) {
                dept.courses.remove(i);
                return "Course removed successfully.";
            }
        }
        return "Course not found.";
    }

    @Override
    public void displayCourses(Department dept) {
        System.out.println("Department: " + dept.departmentName);
        for (Course c : dept.courses) {
            System.out.println("- " + c.courseCode + ": " + c.courseName);
        }
    }
}