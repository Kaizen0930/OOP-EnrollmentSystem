package org.example;

public class Student {

     private String studentID;
     private String studentName;
     private String program;


    public Student(String studentID, String studentName, String program) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.program = program;
    }


    public Student() {
    }


    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getProgram() {
        return program;
    }


    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}

