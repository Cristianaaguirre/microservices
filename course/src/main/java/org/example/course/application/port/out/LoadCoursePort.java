package org.example.course.application.port.out;

import org.example.course.domain.Course;

import java.util.List;

public interface LoadCoursePort {

    Course getCourse(Long id);
    List<Course> getCourses();
    List<Course> getCourses(List<Long> ids);
}
