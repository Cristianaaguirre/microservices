package org.example.course.adapter.out;

import lombok.RequiredArgsConstructor;
import org.example.course.application.port.out.LoadCoursePort;
import org.example.course.application.port.out.UpdateCoursePort;
import org.example.course.domain.Course;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CourseAdapter implements LoadCoursePort, UpdateCoursePort {

    private final CourseEntityRepository repository;

    @Override
    public Course getCourse(Long id) {
        return Optional
                .of(repository.getReferenceById(id))
                .map(CourseMapper::entityToDomain)
                .orElseThrow();
    }

    @Override
    public void saveCourse(Course course) {
        repository.saveAndFlush(CourseMapper.domainToEntity(course));
    }
}
