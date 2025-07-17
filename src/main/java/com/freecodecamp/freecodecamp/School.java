package com.freecodecamp.freecodecamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity // Declares the class as a JPA entity(table in a database)
public class School {

    // Declaring the variables/attributes
    @Id                                                                               // Sets the variable as the primary key of the table
    @GeneratedValue                                                                   // The value for the field is auto-generated
    private Integer id;
    private String name;

    @OneToMany(                                                                      // One-to-Many relation with another Student(class/entity)
            mappedBy = "school"                                                      // Refers to school field in the Student class (name of field of the foreign key in Student table)
    )
    @JsonIgnore                                                                      // Ignores this field during JSON serialization to avoid infinite recursion
    private List<Student> students;


    // No argument constructor necessity for JPA
    public School() {
    }

    // Constructor to create School with a name
    public School(String name) {
        this.name = name;
    }

    // Getter for id
    public Integer getId() {
        return id;
    }

    // Setter for id
    public void setId(Integer id) {
        this.id = id;
    }

    // Getter for School name
    public String getName() {
        return name;
    }

    // Setter for the School name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for List of all the students in the School
    public List<Student> getStudents() {
        return students;
    }

    // Setter for students of the School
    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
