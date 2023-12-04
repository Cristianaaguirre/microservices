package org.example.course.adapter.out;

import org.example.course.domain.Course;

public class CourseMapper {

    public static Course entityToDomain(CourseEntity entity) {
        return new Course(entity.getId(), entity.getName(), entity.getProfessor());
    }

    public static CourseEntity domainToEntity(Course domain) {
        return new CourseEntity(domain.getName(), domain.getProfessor());
    }
}
