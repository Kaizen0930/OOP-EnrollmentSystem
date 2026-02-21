package org.example;

import org.example.model.Course;
import org.example.model.Student;
import org.example.service.CourseService;
import org.example.service.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();

        Student student = new Student();
        student.setStudentID("012930");
        student.setStudentName("John Doe");
        student.setProgram("Information Technology");

        studentService.addStudent(student);
        studentService.addStudent(new Student("012931", "Jane Smith", "Computer Science"));

        Course course = new Course();
        course.setcourseID("932875");
        course.setcourseName("Interprog");
        course.setprogram("BSIT");

        courseService.addCourse(course);
        courseService.addCourse(new Course("112233", "Data Structures", "BSCS"));

        studentService.displayAll();
        System.out.println();
        courseService.displayAll();
    }
}