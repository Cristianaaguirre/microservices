package org.example.students.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringStudentRepository extends JpaRepository<StudentEntity, Long> {
}
