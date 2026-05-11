package org.example.Interface;

import org.example.model.Student;
import org.example.model.Section;
import org.example.model.Department;
import org.example.exception.SectionFullException; // 1. Add this import

public interface IEnrollmentService {

    // 2. Add "throws SectionFullException" to the end of this line
    boolean enrollStudentInSection(Student student, Section section) throws SectionFullException;

    void viewDepartmentHierarchy(Department department);
}