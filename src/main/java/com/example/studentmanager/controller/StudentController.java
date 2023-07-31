package com.example.studentmanager.controller;

import com.example.studentmanager.model.Student;
import com.example.studentmanager.repository.StudentCrudRepository;
import com.example.studentmanager.repository.StudentJPARepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class StudentController {

    private final StudentJPARepository jpaRepository;
    private final StudentCrudRepository crudRepository;

    public StudentController(StudentJPARepository studentJPARepository, StudentCrudRepository studentCrudRepository) {
        this.jpaRepository = studentJPARepository;
        this.crudRepository = studentCrudRepository;
    }


    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>((List<Student>) crudRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/students/edit")
    public ResponseEntity<Student> addNewStudent(@RequestBody Student student) {
        student.setId();
        crudRepository.save(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/students/edit")
    public ResponseEntity<?> removeStudent(@RequestBody UUID uuid) {
        crudRepository.deleteById(uuid);
        return ResponseEntity.ok("Entity deleted");
    }

    @PutMapping("/students/edit")
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        crudRepository.save(student);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @GetMapping("/students/find")
    public ResponseEntity<List<Student>> findStudentsByName(@RequestBody String name) {
        List<Student> result = jpaRepository.findStudentsByFirstNameContainsIgnoreCase(name);
        List<Student> list2 = jpaRepository.findStudentsByLastNameContainsIgnoreCase(name);

        for (Student s : list2) {
            if (!result.contains(s)){
                result.add(s);
            }
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
