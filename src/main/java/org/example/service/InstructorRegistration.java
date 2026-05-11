package org.example.service;

import org.example.interfaces.IInstructorService;
import org.example.model.Instructor;
import java.util.ArrayList;

public class InstructorRegistration implements IInstructorService {
    public ArrayList<Instructor> instructorList = new ArrayList<>();

    public InstructorRegistration() {}

    @Override
    public void addInstructor(Instructor instructor) {
        for (Instructor i : instructorList) {
            if (i.id == instructor.id) {
                System.out.println("Duplicate instructor ID.");
                return;
            }
        }
        instructorList.add(instructor);
        System.out.println("Instructor added successfully.");
    }

    @Override
    public ArrayList<Instructor> getAllInstructors() {
        return instructorList;
    }

    @Override
    public String updateInstructor(int id, String name, ArrayList<String> courses) {
        for (Instructor i : instructorList) {
            if (i.id == id) {
                i.name = name;
                i.courses = courses;
                return "Instructor updated successfully.";
            }
        }
        return "Instructor not found.";
    }

    @Override
    public String removeInstructor(int id) {
        for (int i = 0; i < instructorList.size(); i++) {
            if (instructorList.get(i).id == id) {
                instructorList.remove(i);
                return "Instructor removed successfully.";
            }
        }
        return "Instructor not found.";
    }

    @Override
    public String getInstructorDetails(int id) {
        for (Instructor i : instructorList) {
            if (i.id == id) return i.toString();
        }
        return "Instructor not found.";
    }

    @Override
    public void assignInstructorToSection(int instructorID, String sectionName) {
        System.out.println("Instructor assigned to section: " + sectionName);
    }
}