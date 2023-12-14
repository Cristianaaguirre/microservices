package org.example.students.application.port.out;

import org.example.students.domain.Student;

import java.util.List;

public interface LoadStudentPort {

    Student getStudent(Long id);
    List<Student> getStudents();
    List<Student> getStudents(List<Long> ids);
}
