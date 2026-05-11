package org.example;

import org.example.model.*;
import org.example.service.*;
import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentRegistration studentService = new StudentRegistration();
        InstructorRegistration instructorService = new InstructorRegistration();
        CourseRegistration courseService = new CourseRegistration();

        int choice;
        do {
            System.out.println("\n[1] Save Student    [5] Save Instructor    [9] Save Course");
            System.out.println("[2] Display Student [6] Display Instructor [10] Display Course");
            System.out.println("[3] Update Student  [7] Update Instructor  [11] Update Course");
            System.out.println("[4] Remove Student  [8] Remove Instructor  [12] Remove Course");
            System.out.println("[13] Display All    [0] End");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("ID: "); int sId = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Name: "); String sName = scanner.nextLine();
                    System.out.print("Program: "); String sProg = scanner.nextLine();
                    studentService.addStudent(new Student(sId, sName, sProg));
                    break;
                case 2: studentService.displayAll(); break;
                case 3:
                    System.out.print("ID to update: "); int usId = scanner.nextInt();
                    studentService.updateStudent(new Student(usId, null, null));
                    break;
                case 4:
                    System.out.print("ID to remove: "); int rsId = scanner.nextInt();
                    studentService.delete(new Student(rsId, null, null));
                    break;
                case 5:
                    System.out.print("ID: "); int iId = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Name: "); String iName = scanner.nextLine();
                    System.out.print("Course: "); String iCourse = scanner.nextLine();
                    ArrayList<String> iList = new ArrayList<>(); iList.add(iCourse);
                    instructorService.addInstructor(new Instructor(iId, iName, iList));
                    break;
                case 6: instructorService.displayAll(); break;
                case 7:
                    System.out.print("ID to update: "); int uiId = scanner.nextInt();
                    instructorService.updateInstructor(new Instructor(uiId, null, null));
                    break;
                case 8:
                    System.out.print("ID to remove: "); int riId = scanner.nextInt();
                    instructorService.delete(new Instructor(riId, null, null));
                    break;
                case 9:
                    System.out.print("ID: "); String cId = scanner.next(); scanner.nextLine();
                    System.out.print("Name: "); String cName = scanner.nextLine();
                    System.out.print("Program: "); String cProg = scanner.nextLine();
                    courseService.addCourse(new Course(cId, cName, cProg));
                    break;
                case 10: courseService.displayAll(); break;
                case 11:
                    System.out.print("ID to update: "); String ucId = scanner.next();
                    courseService.updateCourse(new Course(ucId, null, null));
                    break;
                case 12:
                    System.out.print("ID to remove: "); String rcId = scanner.next();
                    courseService.delete(new Course(rcId, null, null));
                    break;
                case 13:
                    studentService.displayAll();
                    instructorService.displayAll();
                    courseService.displayAll();
                    break;
                case 0: System.out.println("Ending..."); break;
                default: System.out.println("Invalid choice");
            }
        } while (choice != 0);

        new Instructor().mainTask();
        new Student().mainTask();
    }
}