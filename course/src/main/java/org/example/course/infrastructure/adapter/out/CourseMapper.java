package org.example.course.infrastructure.adapter.out;

import org.example.course.domain.Course;
import org.example.course.infrastructure.entities.CourseEntity;

public class CourseMapper {

    public static Course entityToDomain(CourseEntity entity) {
        return Course.builder()
                .id(entity.getId())
                .name(entity.getName())
                .professor(entity.getProfessor())
                .students(entity.getStudents())
                .build();
    }

    public static CourseEntity domainToEntity(Course domain) {
        return CourseEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .professor(domain.getProfessor())
                .students(domain.getStudents())
                .build();
    }
}
