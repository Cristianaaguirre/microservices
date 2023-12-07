package org.example.course.adapter.out;

import lombok.RequiredArgsConstructor;
import org.example.course.application.port.out.LoadCoursePort;
import org.example.course.application.port.out.UpdateCoursePort;
import org.example.course.domain.Course;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CoursePersistenceAdapter implements LoadCoursePort, UpdateCoursePort {

    private final SpringCourseRepository repository;

    @Override
    public Course getCourse(Long id) {
        return Optional
                .of(repository.getReferenceById(id))
                .map(CourseMapper::entityToDomain)
                .orElseThrow();
    }

    @Override
    public List<Course> getCourses() {
        return repository.findAll()
                .stream()
                .map(CourseMapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void saveCourse(Course course) {
        repository.saveAndFlush(CourseMapper.domainToEntity(course));
    }
}
