package org.example.model;

public abstract class Instructor extends Person {
    public String program;

    public Instructor() { super(); }

    public Instructor(String id, String name, String program) {
        super(id, name);
        this.program = program;
    }

    @Override
    void mainTask(){
        System.out.println("Teacher teaches");
    }

    @Override
    public String toString() {
        return "Instructor [ID=" + id + ", Name=" + name + ", Dept=" + program + "]";
    }
}