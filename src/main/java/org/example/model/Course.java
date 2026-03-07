package org.example.model;

public class Course {
    public String courseID;
    public String courseName;
    public String program;

    public Course() {}

    public Course(String courseID, String courseName, String program) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.program = program;
    }

    @Override
    public String toString() {
        return "Course [ID=" + courseID + ", Name=" + courseName + ", Program=" + program + "]";
    }
}