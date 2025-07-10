package com.freecodecamp.freecodecamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity  // Declares the class as a JPA entity (a table in the database)
public class Student {

    // Declaring the Variables/Attributes
    @Id
    @GeneratedValue
    @Column()
    private Integer id;
    @Column()
    private String firstname;
    @Column()
    private String lastname;
    @Column()
    private String email;
    @Column()
    private Integer age;

    // Map the entity with another entity(class)
    @OneToOne(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    private StudentProfile studentProfile;


    // Map the entity with another entity(class)
    @ManyToOne
    @JoinColumn(
            name = "school_id"
    )
    private School school;


    // Getters, Setters and Constructors
    public Student() {
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

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
