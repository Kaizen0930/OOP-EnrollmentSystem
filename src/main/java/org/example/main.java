package org.example;

import org.example.model.*;
import org.example.service.*;
import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("ID: "); int sId = sc.nextInt(); sc.nextLine();
                    System.out.print("Name: "); String sName = sc.nextLine();
                    System.out.print("Program: "); String sProg = sc.nextLine();
                    studentService.addStudent(new Student(sId, sName, sProg));
                    break;
                case 2:
                    for(Student s : studentService.getAllStudents()) System.out.println(s);
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
                    for(Instructor i : instructorService.getAllInstructors()) System.out.println(i);
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
                    System.out.print("ID: "); String cId = sc.next(); sc.nextLine();
                    System.out.print("Name: "); String cName = sc.nextLine();
                    System.out.print("Program: "); String cProg = sc.nextLine();
                    courseService.addCourse(new Course(cId, cName, cProg));
                    break;
                case 10:
                    for(Course c : courseService.getAllCourses()) System.out.println(c);
                    break;
                case 11:
                    System.out.print("ID to update: "); String ucId = sc.next(); sc.nextLine();
                    System.out.print("New Name: "); String ucn = sc.nextLine();
                    System.out.print("New Program: "); String ucp = sc.nextLine();
                    courseService.updateCourse(ucId, ucn, ucp);
                    break;
                case 12:
                    System.out.print("ID to remove: "); String rcId = sc.next();
                    courseService.removeCourse(rcId);
                    break;
                case 13:
                    for(Student s : studentService.getAllStudents()) System.out.println(s);
                    for(Instructor i : instructorService.getAllInstructors()) System.out.println(i);
                    for(Course c : courseService.getAllCourses()) System.out.println(c);
                    break;
                case 0: System.out.println("Ending..."); break;
                default: System.out.println("Invalid choice");
            }
        } while (choice != 0);

        new Instructor().mainTask();
        new Student().mainTask();
    }
}