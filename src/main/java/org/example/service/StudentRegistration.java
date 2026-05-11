package org.example.service;

import org.example.interfaces.IStudentService;
import org.example.model.Student;
import java.util.ArrayList;

public class StudentRegistration implements IStudentService {
    public ArrayList<Student> studentList = new ArrayList<>();

    public StudentRegistration() {}

    @Override
    public void addStudent(Student student) {
        for (Student s : studentList) {
            if (s.id == student.id) {
                System.out.println("Duplicate student ID.");
                return;
            }
        }
        studentList.add(student);
        System.out.println("Student added successfully.");
    }

    @Override
    public ArrayList<Student> getAllStudents() {
        return studentList;
    }

    @Override
    public String updateStudent(int id, String name, String program) {
        for (Student s : studentList) {
            if (s.id == id) {
                s.name = name;
                s.program = program;
                return "Student updated successfully.";
            }
        }
        return "Student not found.";
    }

    @Override
    public String removeStudent(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).id == id) {
                studentList.remove(i);
                return "Student removed successfully.";
            }
        }
        return "Student not found.";
    }
}