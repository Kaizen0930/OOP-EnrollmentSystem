package org.example.model;

import java.util.ArrayList;

public class Department {
    public String departmentName;
    public ArrayList<Section> sections;

    public Department() {
        this.sections = new ArrayList<>();
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.sections = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Department [Name=" + departmentName + ", Section Count=" + sections.size() + "]";
    }
}