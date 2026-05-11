package org.example.service;

import org.example.model.Student;
import java.util.*;

public class StudentRegistration {
    public ArrayList<Student> studentList = new ArrayList<>();
    public Scanner scanner = new Scanner(System.in);

    public StudentRegistration() {}

    // Create
    public void addStudent(Student student) {
        studentList.add(student);
    }

    // Read
    public void displayAll() {
        System.out.println(studentList);
    }

    // Update
    public String updateStudent(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).id == student.id) {
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();

                System.out.print("Enter program: ");
                String program = scanner.nextLine();

                studentList.set(i, new Student(student.id, name, program));
                return "Successfully updated";
            }
        }
        return "Student not found";
    }

    // Remove
    public String delete(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).id == student.id) {
                studentList.remove(i);
                return "Successfully deleted.";
            }
        }
        return "Error";
    }

    @Override
    public String toString() {
        return "StudentRegistration [Total Students=" + studentList.size() + "]";
    }
}