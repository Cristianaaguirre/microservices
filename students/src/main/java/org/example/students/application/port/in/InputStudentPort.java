package org.example.students.application.port.in;

import org.example.students.domain.Student;
import org.example.students.infrastructure.adapter.out.Course;

import java.util.List;

public interface InputStudentPort {

    void createStudent(Student student);
    Student getStudent(Long id);
    List<Student> getStudents();
    List<Student> getStudents(List<Long> ids);
    void addCourse(CourseCommand course);
    List<Course> getCourses(Long id);
}
