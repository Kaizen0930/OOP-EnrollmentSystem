package org.example;

public class Course {

    private String courseID;
    private String courseName;
    private String program;

    public Course(){

    }

    public Course(String courseID, String courseName, String program) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.program = program;
    }

    public String getcourseID() {
        return courseID;
    }

    public void setcourseID(String CourseID) {
        this.courseID = CourseID;
    }

    public String getcourseName() {
        return courseName;
    }

    public String getprogram() {
        return program;
    }

    public void setcourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setprogram(String program) {
        this.program = program;
    }

    //Comment
    }

