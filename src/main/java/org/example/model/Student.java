package org.example.model;

public class Student extends Person {
    public String program;
    public String scholarshipType; // "ACADEMIC", "ATHLETIC", "FINANCIAL_AID", or null
    public double tuitionFee;

    public Student() {}

    public Student(int id, String name, String program) {
        super(id, name);
        this.program = program;
        this.scholarshipType = null;
        this.tuitionFee = 0.0;
    }

    public Student(int id, String name, String program, double tuitionFee) {
        super(id, name);
        this.program = program;
        this.scholarshipType = null;
        this.tuitionFee = tuitionFee;
    }

    @Override
    public String toString() {
        String scholarship = (scholarshipType != null) ? scholarshipType : "None";
        return "Student [ID=" + id + ", Name=" + name + ", Program=" + program
                + ", Scholarship=" + scholarship
                + ", Tuition=₱" + String.format("%.2f", tuitionFee) + "]";
    }

    @Override
    public void mainTask() {
        System.out.println("I Study");
    }
}