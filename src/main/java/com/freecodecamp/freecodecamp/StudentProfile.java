package com.freecodecamp.freecodecamp;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class StudentProfile {

    // Declaring the Variables/Attributes
    @Id
    @GeneratedValue
    private Integer id;
    private String bio;

    // Map the entity with another entity(class)
    @OneToOne
    @JoinColumn(
            name = "student_id"
    )
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    // Getters, Setters and Constructors
    public StudentProfile(String bio) {
        this.bio = bio;
    }

    public StudentProfile() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
