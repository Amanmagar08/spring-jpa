package com.freecodecamp.freecodecamp;

import jakarta.persistence.*;

@Entity
public class StudentProfile {

    // Marks the field as the Primary key
    @Id
    @GeneratedValue         // The value for the field is auto-generated
    private Integer id;
    private String bio;

    // Map the entity with another entity(class) with a one-to-one relation
    @OneToOne
    @JoinColumn(                        // Specifies the Foreign Key of the table
            name = "student_id"         // Foreign key of the table referencing student field Student class
    )
    private Student student;

    // No argument constructor as required for Spring JPA
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
