package com.example.studentmanager.repository;

import com.example.studentmanager.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentCrudRepository extends CrudRepository<Student, UUID> {
}
