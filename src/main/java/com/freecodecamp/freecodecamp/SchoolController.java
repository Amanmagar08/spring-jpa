package com.freecodecamp.freecodecamp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Marks the class as a REST Controller/API, enabling it to hand HTTP Requests and return JSON responses
@RestController
public class SchoolController {

    private final SchoolRepository schoolRepository;

    // Constructor injection
    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    // Maps HTTP Post request to the following endpoint
    @PostMapping("/schools")
    public School create(
            @RequestBody School school          // Accepts JSON request body and maps it to a School object
    ) {
        return schoolRepository.save(school);   // Adds the school to the repository(database) and returns it

    }

    // Maps HTTP Get request to the following endpoint
    @GetMapping("/schools")
    public List<School> findAll() {             // Returns all the Schools in database
        return schoolRepository.findAll();      // Fetches values in the database

    }
}
