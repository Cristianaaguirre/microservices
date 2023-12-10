package org.example.students.infrastructure.repositories;

import org.example.students.infrastructure.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringStudentRepository extends JpaRepository<StudentEntity, Long> {
}
