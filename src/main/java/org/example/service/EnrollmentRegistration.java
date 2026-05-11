package org.example.service;

import org.example.Interface.IEnrollmentService;
import org.example.model.*;
import org.example.exception.SectionFullException;

public class EnrollmentRegistration implements IEnrollmentService {

    public static final double ACADEMIC_DISCOUNT     = 0.50;
    public static final double ATHLETIC_DISCOUNT     = 0.30;
    public static final double FINANCIAL_AID_DISCOUNT = 0.75;

    public EnrollmentRegistration() {}

    @Override
    public boolean enrollStudentInSection(Student student, Section section) throws SectionFullException {
        if (student == null) {
            System.out.println("Enrollment failed: Student cannot be null.");
            return false;
        }
        if (section == null) {
            System.out.println("Enrollment failed: Section cannot be null.");
            return false;
        }

        for (Student enrolled : section.students) {
            if (enrolled.id == student.id) {
                System.out.println("Enrollment failed: Student " + student.name
                        + " (ID=" + student.id + ") is already enrolled in section "
                        + section.sectionName + ".");
                return false;
            }
        }

        if (section.students.size() >= section.maxCapacity) {
            throw new SectionFullException("Enrollment failed: Section "
                    + section.sectionName + " is at max capacity ("
                    + section.maxCapacity + ").");
        }

        section.students.add(student);
        System.out.println("Student " + student.name + " successfully enrolled in "
                + section.sectionName + ".");
        return true;
    }

    @Override
    public String applyScholarship(Student student, String scholarshipType) {
        if (student == null) {
            return "Scholarship failed: Student cannot be null.";
        }

        if (scholarshipType == null || scholarshipType.trim().isEmpty()) {
            return "Scholarship failed: Scholarship type cannot be empty.";
        }

        String type = scholarshipType.trim().toUpperCase();
        if (!type.equals("ACADEMIC") && !type.equals("ATHLETIC") && !type.equals("FINANCIAL_AID")) {
            return "Scholarship failed: Invalid scholarship type \"" + scholarshipType
                    + "\". Valid types are: ACADEMIC, ATHLETIC, FINANCIAL_AID.";
        }

        if (type.equals(student.scholarshipType)) {
            return "Scholarship failed: Student " + student.name
                    + " already has a " + type + " scholarship.";
        }

        if (student.tuitionFee <= 0) {
            return "Scholarship failed: Student " + student.name
                    + " has no tuition fee set. Please set a tuition fee before applying a scholarship.";
        }

        double discountRate = getDiscountRate(type);
        double discountAmount = student.tuitionFee * discountRate;
        double newFee = student.tuitionFee - discountAmount;

        String previousScholarship = student.scholarshipType;
        student.scholarshipType = type;
        student.tuitionFee = newFee;

        String message = "Scholarship applied: " + type
                + " (" + (int)(discountRate * 100) + "% discount)"
                + " for student " + student.name + "."
                + " Tuition reduced from ₱" + String.format("%.2f", student.tuitionFee + discountAmount)
                + " to ₱" + String.format("%.2f", newFee) + ".";

        if (previousScholarship != null) {
            message += " (Replaced previous scholarship: " + previousScholarship + ")";
        }

        return message;
    }

    private double getDiscountRate(String type) {
        switch (type) {
            case "ACADEMIC":      return ACADEMIC_DISCOUNT;
            case "ATHLETIC":      return ATHLETIC_DISCOUNT;
            case "FINANCIAL_AID": return FINANCIAL_AID_DISCOUNT;
            default:              return 0.0;
        }
    }

    @Override
    public void viewDepartmentHierarchy(Department department) {
        if (department == null) {
            System.out.println("No department to display.");
            return;
        }
        System.out.println("=== Department: " + department.departmentName + " ===");
        if (department.sections == null || department.sections.isEmpty()) {
            System.out.println("  No sections available.");
            return;
        }
        for (Section section : department.sections) {
            System.out.println("  Section: " + section.sectionName
                    + " [" + section.students.size() + "/" + section.maxCapacity + "]");
            System.out.println("  Instructor: "
                    + (section.instructor != null ? section.instructor.name : "None"));
            if (section.students.isEmpty()) {
                System.out.println("  Students: (none)");
            } else {
                System.out.println("  Students:");
                for (Student student : section.students) {
                    System.out.println("    - " + student);
                }
            }
            System.out.println();
        }
    }
}