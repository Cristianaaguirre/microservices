package org.example.course.adapter.out;

import org.example.course.domain.Course;

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
                .name(domain.getName())
                .professor(domain.getProfessor())
                .students(domain.getStudents())
                .build();
    }
}
