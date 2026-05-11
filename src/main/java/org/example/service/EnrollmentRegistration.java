package org.example.service;

import org.example.Interface.IEnrollmentService;
import org.example.model.*;
import org.example.exception.SectionFullException; // Make sure this import is here

public class EnrollmentRegistration implements IEnrollmentService {

    public EnrollmentRegistration() {}

    @Override
    public boolean enrollStudentInSection(Student student, Section section) throws SectionFullException {
        if (section.students.size() >= section.maxCapacity) {
            System.out.println("Section is full.");
            // FIX: We now throw the exception so the JUnit test can catch it
            throw new SectionFullException("Enrollment failed: Section " + section.sectionName + " is at max capacity.");
        }

        section.students.add(student);
        System.out.println("Student enrolled successfully.");
        return true;
    }

    @Override
    public void viewDepartmentHierarchy(Department department) {
        System.out.println("Department: " + department.departmentName);
        if (department.sections != null) {
            for (Section section : department.sections) {
                System.out.println("Section: " + section.sectionName);
                if (section.instructor != null) {
                    System.out.println("Instructor: " + section.instructor.name);
                }
                System.out.println("Students:");
                if (section.students != null) {
                    for (Student student : section.students) {
                        System.out.println("- " + student.name);
                    }
                }
                System.out.println();
            }
        }
    }
}