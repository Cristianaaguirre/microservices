package org.example.course.application.port.in;

import org.example.course.domain.Course;
import org.example.course.infrastructure.adapter.out.Student;

import java.util.List;

public interface InputCoursePort {

    void addCourse(Course course);
    void addStudent(StudentCommand intermediate);
    Course getCourse(Long id);
    List<Course> getCourses();
    List<Course> getCourses(List<Long> ids);
    List<Student> getStudents(Long id);
}
