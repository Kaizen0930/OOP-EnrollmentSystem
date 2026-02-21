package org.example;

import org.example.model.Course;
import org.example.model.Student;
import org.example.service.CourseService;
import org.example.service.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();

        studentService.addStudent(new Student("012930", "John Doe", "Information Technology"));
        studentService.addStudent(new Student("012931", "Jane Smith", "Computer Science"));

        courseService.addCourse(new Course("932875", "Interprog", "BSIT"));
        courseService.addCourse(new Course("112233", "Data Structures", "BSCS"));

        studentService.displayAll();
        courseService.displayAll();

        studentService.updateStudent(new Student("012930", "John Doe", "Cyber Security"));
        courseService.updateCourse(new Course("932875", "Advanced Java", "BSIT"));

        studentService.displayAll();
        courseService.displayAll();

        System.out.println(studentService.deleteStudent(new Student("012931")));
        System.out.println(courseService.deleteCourse(new Course("112233")));

    }
}