package org.example.students.application.port.in;

import org.example.students.domain.Student;

import java.util.List;

public interface InputStudentPort {

    Student getStudent(Long id);
    List<Student> getStudents();
    void addCourse(CourseCommand course);
}