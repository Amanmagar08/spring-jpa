package com.freecodecamp.freecodecamp;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks the class as a REST controller, allowing it to handle HTTP requests and return JSON responses
public class Controller {

    private final StudentRepository repository;
    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;  // Must be final + injected

    // Constructor(Constructor injection)
    public Controller(
            StudentRepository studentRepository,
            StudentRepository repository, SchoolRepository schoolRepository
    ) {
        this.studentRepository = studentRepository;
        this.repository = repository;
        this.schoolRepository = schoolRepository;
    }


    // Maps HTTP POST requests to the following endpoint
    @PostMapping("/students")
    public Student post(@RequestBody Student student) {                         // Accepts JSON request body and maps it to a Student object
        Long schoolId = Long.valueOf(student.getSchool().getId());              // Extracts the School id from the student object

        School school = schoolRepository.findById(student.getSchool().getId())  // Find id of the school in schoolRepository
                .orElseThrow(() -> new RuntimeException("School not found"));   // If school id is not found throw a runtime exception
        student.setSchool(school);                                              // Set school id for the student as the id provided in the HTTP request

        return repository.save(student);                                        // Adds the student to the database and return the saved entity
    }


    // Maps HTTP GET requests to the following endpoint
    @GetMapping("/students")
    public List<Student> finaAllStudent() {
        return repository.findAll();            // Fetches and Return all values(students) found in the database(repository)
    }

    // Maps HTTP GET requests to the following endpoint
    @GetMapping("/students/{id}")
    public Student findById(
           @PathVariable("id") Integer id       // Extracts value id from the URL 
    ) {
        return repository.findById(id)          // Fetches and returns the data for the specific id from the repository(database)
                .orElse(new Student());         // If no student is found in the repository(database) of that id return a new student
    }
}

