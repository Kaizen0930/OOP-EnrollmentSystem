package org.example.model;

public class Student extends Person {
    public String program;

    public Student() { super(); }

    public Student(String id, String name, String program) {
        super(id, name); // Passes ID and Name to Person
        this.program = program;
    }

    @Override
    public String toString() {
        return "Student [ID=" + id + ", Name=" + name + ", Program=" + program + "]";
    }
}