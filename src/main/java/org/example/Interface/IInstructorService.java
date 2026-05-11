package org.example.interfaces;

import org.example.model.Instructor;

import java.util.ArrayList;

public interface IInstructorService {

    void addInstructor(Instructor instructor);

    ArrayList<Instructor> getAllInstructors();

    String updateInstructor(int id, String name, ArrayList<String> courses);

    String removeInstructor(int id);

    String getInstructorDetails(int id);

    void assignInstructorToSection(int instructorID, String sectionName);
}