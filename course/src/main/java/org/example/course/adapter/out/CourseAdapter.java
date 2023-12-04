package org.example.course.adapter.out;

import org.example.course.application.port.out.LoadCoursePort;
import org.example.course.application.port.out.UpdateCoursePort;
import org.example.course.domain.Course;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CourseAdapter implements LoadCoursePort, UpdateCoursePort {

    private final CourseEntityRepository repository;

    public CourseAdapter(CourseEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Course getCourse() {
        return Optional
                .of(repository.getReferenceById(1L))
                .map(CourseMapper::entityToDomain)
                .orElseThrow();
    }

    @Override
    public void saveCourse() {

    }
}
