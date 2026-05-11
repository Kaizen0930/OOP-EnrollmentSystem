package org.example;

import org.example.model.*;
import org.example.service.*;
import org.example.exception.SectionFullException;
import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Services
        StudentRegistration studentService = new StudentRegistration();
        InstructorRegistration instructorService = new InstructorRegistration();
        CourseRegistration courseService = new CourseRegistration();
        EnrollmentRegistration enrollmentService = new EnrollmentRegistration();

        // Setup Demo Department and Section
        Department dept = new Department("College of Computer Studies");
        Section itSection = new Section("IT-101", 2); // Set to 2 for easy capacity demo
        dept.sections.add(itSection);

        int choice = -1;
        do {
            try {
                System.out.println("\n--- ENROLLMENT SYSTEM ---");
                System.out.println("[1] Save Student      [5] Save Instructor    [9] Save Course");
                System.out.println("[2] Display Student   [6] Display Instructor [10] Display Course");
                System.out.println("[3] Update Student    [7] Update Instructor  [11] Update Course");
                System.out.println("[4] Remove Student    [8] Remove Instructor  [12] Remove Course");
                System.out.println("[13] Display All      [14] Enroll & Scholarship [0] End");
                System.out.print("Enter choice: ");

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("ID: "); int sId = sc.nextInt(); sc.nextLine();
                        System.out.print("Name: "); String sName = sc.nextLine();
                        System.out.print("Program: "); String sProg = sc.nextLine();
                        System.out.print("Base Tuition: "); double sFee = sc.nextDouble(); sc.nextLine();
                        studentService.addStudent(new Student(sId, sName, sProg, sFee));
                        break;
                    case 2:
                        for (Student s : studentService.getAllStudents()) System.out.println(s);
                        break;
                    case 3:
                        System.out.print("ID to update: "); int usId = sc.nextInt(); sc.nextLine();
                        System.out.print("New Name: "); String un = sc.nextLine();
                        System.out.print("New Program: "); String up = sc.nextLine();
                        studentService.updateStudent(usId, un, up);
                        break;
                    case 4:
                        System.out.print("ID to remove: "); int rsId = sc.nextInt();
                        studentService.removeStudent(rsId);
                        break;
                    case 5:
                        System.out.print("ID: "); int iId = sc.nextInt(); sc.nextLine();
                        System.out.print("Name: "); String iName = sc.nextLine();
                        System.out.print("Course: "); String iCourse = sc.nextLine();
                        ArrayList<String> iList = new ArrayList<>(); iList.add(iCourse);
                        instructorService.addInstructor(new Instructor(iId, iName, iList));
                        break;
                    case 6:
                        for (Instructor i : instructorService.getAllInstructors()) System.out.println(i);
                        break;
                    case 7:
                        System.out.print("ID to update: "); int uiId = sc.nextInt(); sc.nextLine();
                        System.out.print("New Name: "); String uin = sc.nextLine();
                        System.out.print("New Course: "); String uic = sc.nextLine();
                        ArrayList<String> uil = new ArrayList<>(); uil.add(uic);
                        instructorService.updateInstructor(uiId, uin, uil);
                        break;
                    case 8:
                        System.out.print("ID to remove: "); int riId = sc.nextInt();
                        instructorService.removeInstructor(riId);
                        break;
                    case 9:
                        System.out.print("Course Code: "); String cId = sc.next(); sc.nextLine();
                        System.out.print("Name: "); String cName = sc.nextLine();
                        System.out.print("Units: "); int cUnits = sc.nextInt(); sc.nextLine();
                        courseService.addCourse(dept, new Course(cId, cName, cUnits));
                        break;
                    case 10:
                        courseService.displayCourses(dept);
                        break;
                    case 11:
                        System.out.print("Course Code to update: "); String ucId = sc.next(); sc.nextLine();
                        System.out.print("New Name: "); String ucn = sc.nextLine();
                        System.out.print("New Units: "); int ucu = sc.nextInt(); sc.nextLine();
                        System.out.println(courseService.updateCourse(dept, ucId, ucn, ucu));
                        break;
                    case 12:
                        System.out.print("Course Code to remove: "); String rcId = sc.next();
                        System.out.println(courseService.removeCourse(dept, rcId));
                        break;
                    case 13:
                        System.out.println("\n--- ALL RECORDS ---");
                        for (Student s : studentService.getAllStudents()) System.out.println(s);
                        for (Instructor i : instructorService.getAllInstructors()) System.out.println(i);
                        courseService.displayCourses(dept);
                        break;
                    case 14:
                        System.out.print("Enter Student ID to Enroll: ");
                        int enrollId = sc.nextInt(); sc.nextLine();

                        Student toEnroll = null;
                        for (Student s : studentService.getAllStudents()) {
                            if (s.id == enrollId) { toEnroll = s; break; }
                        }

                        if (toEnroll != null) {
                            System.out.print("Scholarship (ACADEMIC/ATHLETIC/FINANCIAL_AID/NONE): ");
                            String type = sc.nextLine().toUpperCase();
                            if(!type.equals("NONE")) {
                                System.out.println(enrollmentService.applyScholarship(toEnroll, type));
                            }

                            try {
                                boolean success = enrollmentService.enrollStudentInSection(toEnroll, itSection);
                                if(success) System.out.println("✅ Student enrolled successfully!");
                            } catch (SectionFullException e) {
                                System.out.println("❌ " + e.getMessage());
                            }
                        } else {
                            System.out.println("Student not found!");
                        }
                        break;
                    case 0: System.out.println("Ending..."); break;
                    default: System.out.println("Invalid choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Validation Error: Please enter a numeric value!");
                sc.nextLine(); // Clear the buffer (crucial for "test" demo)
                choice = -1;
            }
        } while (choice != 0);

        new Instructor().mainTask();
        new Student().mainTask();
    }
}