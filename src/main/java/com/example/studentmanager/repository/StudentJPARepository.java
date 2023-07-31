package com.example.studentmanager.repository;

import com.example.studentmanager.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentJPARepository extends JpaRepository<Student, UUID> {

    List<Student> findStudentsByLastNameContainsIgnoreCase(String name);
    List<Student> findStudentsByFirstNameContainsIgnoreCase(String name);

}
