package com.freecodecamp.freecodecamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity  // Declares the class as a JPA entity (a table in the database)
public class Student {

    // Declaring the Variables/Attributes
    @Id                                             // Declares the attribute as the primary key
    @GeneratedValue                                 // Value for the field is auto-generated
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private Integer age;

    // Map the entity with another entity(class)
    @OneToOne(                                      // One-to-One relation with StudentProfile
            mappedBy = "student",                   // Refers to the student field in StudentProfile class/entity
            cascade = CascadeType.ALL               // Deleting a Student also deletes the associated StudentProfile
    )
    private StudentProfile studentProfile;          // The associated StudentProfile of this Student


    // Map the entity with another entity(class)
    @ManyToOne                                      // Many-to-one relation with School
    @JoinColumn(                                    // Specifies foreign key column for the relationship
            name = "school_id"                      // Foreign key of the table referencing entity School's school
    )
    private School school;


    // Getters, Setters and Constructors

    // No argument constructor(required for SpringJPA)
    public Student() {
    }

    // Getter for studentProfile
    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    // Setter for studentProfile
    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    // Getter for school
    public School getSchool() {
        return school;
    }

    // Setter of school
    public void setSchool(School school) {
        this.school = school;
    }

    // Constructor
    public Student(String firstname, String lastname, String email, Integer age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
