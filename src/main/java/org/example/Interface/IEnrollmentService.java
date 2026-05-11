package org.example.Interface;

import org.example.model.Student;
import org.example.model.Section;
import org.example.model.Department;
import org.example.exception.SectionFullException;

public interface IEnrollmentService {

    boolean enrollStudentInSection(Student student, Section section) throws SectionFullException;

    void viewDepartmentHierarchy(Department department);

    String applyScholarship(Student student, String scholarshipType);
}