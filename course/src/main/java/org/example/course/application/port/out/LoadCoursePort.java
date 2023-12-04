package org.example.course.application.port.out;

import org.example.course.domain.Course;

public interface LoadCoursePort {

    Course getCourse(Long id);
}
