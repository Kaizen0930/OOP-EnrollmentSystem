package org.example.model;

public abstract class Person {
    public int id;
    public String name;

    public Person() {}

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void mainTask();
}