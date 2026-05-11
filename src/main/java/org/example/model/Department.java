package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    public String departmentName;
    public List<Course> courses = new ArrayList<>();
    public List<Section> sections = new ArrayList<>();

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }
}