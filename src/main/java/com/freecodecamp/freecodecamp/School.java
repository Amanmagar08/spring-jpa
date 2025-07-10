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
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    // Map the entity with another entity
    @OneToMany(
            mappedBy = "school"
    )
    @JsonIgnore
    private List<Student> students;


    // Getters, Setters and Constructors
    public School() {
    }

    public School(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


}
