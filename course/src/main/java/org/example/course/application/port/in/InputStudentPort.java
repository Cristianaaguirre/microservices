package org.example.course.application.port.in;

import org.example.course.domain.Course;

import java.util.List;

public interface InputStudentPort {

    void addCourse(Course course);
    void addStudent(StudentCommand intermediate);
    Course getCourse(Long id);
    List<Course> getCourses();
}
