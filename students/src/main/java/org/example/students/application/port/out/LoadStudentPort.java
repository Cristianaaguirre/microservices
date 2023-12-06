package org.example.students.application.port.out;

import org.example.students.domain.Student;

public interface LoadStudentPort {

    Student getStudent(Long id);
}
