package org.example.model;

import java.util.ArrayList;

public class Section {
    public String sectionName;
    public int maxCapacity;
    public ArrayList<Student> students;
    public Instructor instructor;

    public Section() {
        this.students = new ArrayList<>();
    }

    public Section(String sectionName, int maxCapacity) {
        this.sectionName = sectionName;
        this.maxCapacity = maxCapacity;
        this.students = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Section [Name=" + sectionName + ", Capacity=" + maxCapacity +
                ", Instructor=" + (instructor != null ? instructor.name : "None") +
                ", Student Count=" + students.size() + "]";
    }
}