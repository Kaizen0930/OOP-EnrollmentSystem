package org.example.service;

import org.example.model.Instructor;
import java.util.*;

public class InstructorRegistration {
    public ArrayList<Instructor> instructorList = new ArrayList<>();
    public Scanner scanner = new Scanner(System.in);

    public InstructorRegistration() {}

    // Create
    public void addInstructor(Instructor instructor) {
        instructorList.add(instructor);
    }

    // Read
    public void displayAll() {
        System.out.println(instructorList);
    }

    // Update
    public String updateInstructor(Instructor instructor) {
        for (int i = 0; i < instructorList.size(); i++) {
            if (instructorList.get(i).id == instructor.id) {
                System.out.print("Enter instructor name: ");
                String name = scanner.nextLine();

                System.out.print("Enter course: ");
                String course = scanner.nextLine();

                ArrayList<String> courses = new ArrayList<>();
                courses.add(course);

                instructorList.set(i, new Instructor(instructor.id, name, courses));
                return "Successfully updated";
            }
        }
        return "Instructor not found";
    }

    // Remove
    public String delete(Instructor instructor) {
        for (int i = 0; i < instructorList.size(); i++) {
            if (instructorList.get(i).id == instructor.id) {
                instructorList.remove(i);
                return "Successfully deleted.";
            }
        }
        return "Error";
    }

    @Override
    public String toString() {
        return "InstructorRegistration [Total Instructors=" + instructorList.size() + "]";
    }
}