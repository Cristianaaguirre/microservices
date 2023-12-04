package org.example.course.application.port.out;

import org.example.course.domain.Course;

public interface UpdateCoursePort {

    void saveCourse(Course course);
}
