package org.example.service;

import org.example.model.Student;
import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> studentList = new ArrayList<>();

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void displayAll() {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }
    }

    public void updateStudent(Student updatedStudent) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentID().equals(updatedStudent.getStudentID())) {
                studentList.set(i, updatedStudent);
                return;
            }
        }
    }

    public String deleteStudent(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentID().equals(student.getStudentID())) {
                studentList.remove(i);
                return "Successfully Deleted Student";
            }
        }
        return "Error: Student not found";
    }
}