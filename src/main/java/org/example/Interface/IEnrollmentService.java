package org.example.Interface;

import org.example.model.Student;

import org.example.model.Section;

import org.example.model.Department;

public interface IEnrollmentService {

    boolean enrollStudentInSection(Student student, Section section);

    void viewDepartmentHierarchy(Department department);
}
