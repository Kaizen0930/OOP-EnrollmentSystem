package org.example.service;

import org.example.Interface.IEnrollmentService;
import org.example.model.*;

public class EnrollmentRegistration implements IEnrollmentService {

    public EnrollmentRegistration() {}

    @Override
    public boolean enrollStudentInSection(Student student, Section section) {
        if (section.students.size() >= section.maxCapacity) {
            System.out.println("Section is full.");
            return false;
        }
        section.students.add(student);
        System.out.println("Student enrolled successfully.");
        return true;
    }

    @Override
    public void viewDepartmentHierarchy(Department department) {
        System.out.println("Department: " + department.departmentName);
        for (Section section : department.sections) {
            System.out.println("Section: " + section.sectionName);
            if (section.instructor != null) {
                System.out.println("Instructor: " + section.instructor.name);
            }
            System.out.println("Students:");
            for (Student student : section.students) {
                System.out.println("- " + student.name);
            }
            System.out.println();
        }
    }
}