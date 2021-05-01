package com.example.comunevtask2java;

public class Model {
    private String title;
    private String firstName;
    private String lastName;

    public Model(String title, String firstName, String lastName){
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
}
