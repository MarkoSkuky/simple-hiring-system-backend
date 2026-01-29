package com.marko.hiringSystem.entity;

import jakarta.persistence.*;

@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private int age;

    public Candidate() {

    }

    public Candidate(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
