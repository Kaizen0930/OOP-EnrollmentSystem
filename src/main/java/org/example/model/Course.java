package org.example.model;

public class Course {
    public String courseCode;
    public String courseName;
    public int units;

    public Course(String courseCode, String courseName, int units) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.units = units;
    }
}