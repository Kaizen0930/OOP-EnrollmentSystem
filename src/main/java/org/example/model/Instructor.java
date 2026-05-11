package org.example.model;

import java.util.ArrayList;

public class Instructor extends Person {
    public ArrayList<String> courses;

    public Instructor() {
        this.courses = new ArrayList<>();
    }

    public Instructor(int id, String name, ArrayList<String> courses) {
        super(id, name);
        this.courses = courses;
    }

    @Override
    public void mainTask() {
        System.out.println("I Teach");
    }

    @Override
    public String toString() {
        return "Instructor [ID=" + id + ", Name=" + name + ", Courses=" + courses + "]";
    }
}