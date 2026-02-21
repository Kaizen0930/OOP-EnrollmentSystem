package org.example.service;

import org.example.model.Student;
import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayAll() {
        for (Student s : students) {
            System.out.println(s);
        }
    }
}