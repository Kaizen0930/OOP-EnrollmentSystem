package org.example.interfaces;

import org.example.model.Student;

import java.util.ArrayList;

public interface IStudentService {

    void addStudent(Student student);

    ArrayList<Student> getAllStudents();

    String updateStudent(int id, String name, String program);

    String removeStudent(int id);
}