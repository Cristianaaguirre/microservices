package org.example.students.infrastructure.adapter.out;

import org.example.students.domain.Student;
import org.example.students.infrastructure.entities.StudentEntity;

public class StudentMapper {

    public static Student entityToDomain(StudentEntity entity) {
        return Student.builder()
                .id(entity.getId())
                .name(entity.getName())
                .courses(entity.getCourses())
                .build();
    }

    public static StudentEntity domainToEntity(Student domain) {
        return StudentEntity.builder()
                .name(domain.getName())
                .courses(domain.getCourses())
                .build();
    }

}
