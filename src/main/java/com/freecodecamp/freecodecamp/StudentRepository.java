package com.freecodecamp.freecodecamp;

import org.springframework.data.jpa.repository.JpaRepository;

// For JPA to manage our database operations without writing boilerplate SQL code
// JpaRepository<entity name to be manage, data type of primary key of the entity>
public interface StudentRepository extends JpaRepository<Student, Integer> {
    

}
