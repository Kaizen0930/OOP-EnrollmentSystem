package org.example;

public class Main {

    public static void main(String[] args) {


        Student student = new Student();
        student.setStudentID("012930");
        student.setStudentName("John Doe");
        student.setProgram("Information Technology");


        System.out.println("Student ID: " + student.getStudentID());
        System.out.println("Student Name: " + student.getStudentName());
        System.out.println("Student Program: " + student.getProgram());

        System.out.println("");

        Course course = new Course();
        course.setcourseID("932875");
        course.setcourseName("Interprog");
        course.setprogram("BSIT");

        System.out.println("Course ID: " + course.getcourseID());
        System.out.println("Course Name: " + course.getcourseName());
        System.out.println("Program: " +  course.getprogram());

    }
}

