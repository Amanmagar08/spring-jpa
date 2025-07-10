package com.freecodecamp.freecodecamp;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    private final StudentRepository repository;

    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;  // Must be final + injected

    // Constructor injection (Recommended)
    public Controller(
            StudentRepository studentRepository,
            StudentRepository repository, SchoolRepository schoolRepository
            // Add this
    ) {
        this.studentRepository = studentRepository;
        this.repository = repository;
        this.schoolRepository = schoolRepository;
    }




    @PostMapping("/students")
    public Student post(@RequestBody Student student) {
        Integer schoolId = student.getSchool().getId();

        School school = schoolRepository.findById(schoolId)
                .orElseThrow(() -> new RuntimeException("School with ID " + schoolId + " not found"));

        student.setSchool(school);
        return repository.save(student);
    }
x


    @GetMapping("/students")
    public List<Student> finaAllStudent() {
        return repository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student findById(
           @PathVariable("id") Integer id
    ) {
        return repository.findById(id)
                .orElse(new Student());
    }
}

