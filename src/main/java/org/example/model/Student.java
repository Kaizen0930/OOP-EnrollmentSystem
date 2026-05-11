package org.example.model;

public class Student extends Person {
    public String program;

    public Student() {}

    public Student(int id, String name, String program) {
        super(id, name);
        this.program = program;
    }

    @Override
    public String toString() {
        return "Student [ID=" + id + ", Name=" + name + ", Program=" + program + "]";
    }

    @Override
    public void mainTask() {
        System.out.println("I Study");
    }
}