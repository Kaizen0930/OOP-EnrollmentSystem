package org.example.model;

import org.example.service.CourseService;
import org.example.service.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();

        studentService.addStudent(new Student(" 012930", " John Doe", " Information Technology"));
        studentService.addStudent(new Student(" 012931", " Jane Smith", " Computer Science"));

        courseService.addCourse(new Course(" 932875", " Interprog", " BSIT"));
        courseService.addCourse(new Course(" 112233", " Data Structures", " BSCS"));

        Instructor prof1 = new Instructor(" 555", " Hopper", " Computer Science");
        Instructor prof2 = new Instructor(" 777", " Eleven", " Information Technology");

        System.out.println(prof1.toString());
        System.out.println(prof2.toString());

        studentService.displayAll();

        courseService.displayAll();

//        courseService.addCourse(new Course("932875", "Interprog", "BSIT"));
//        courseService.addCourse(new Course("112233", "Data Structures", "BSCS"));
//
//        studentService.displayAll();
//        courseService.displayAll();
//
//        studentService.updateStudent(new Student("012930", "John Doe", "Cyber Security"));
//
//        studentService.displayAll();
    }
}