package org.example.service;

// Check your sidebar: If the folder is named "Interface", use this:
import org.example.Interface.IStudentService;
import org.example.model.Student;
import java.util.ArrayList;

public class StudentRegistration implements IStudentService {

    // Using private for better practice, but keeping the ArrayList dull and simple
    private ArrayList<Student> studentList = new ArrayList<>();

    public StudentRegistration() {}

    @Override
    public void addStudent(Student student) {
        for (Student s : studentList) {
            if (s.id == student.id) {
                System.out.println("Student ID already exists.");
                return;
            }
        }
        studentList.add(student);
        System.out.println("Student " + student.name + " added successfully.");
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
                return "Updated successfully.";
            }
        }
        return "Not found.";
    }

    @Override
    public String removeStudent(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).id == id) {
                studentList.remove(i);
                return "Removed successfully.";
            }
        }
        return "Not found.";
    }
}