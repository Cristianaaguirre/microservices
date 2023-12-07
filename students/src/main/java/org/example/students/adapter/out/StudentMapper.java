package org.example.students.adapter.out;

import org.example.students.domain.Student;

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
                .id(domain.getId())
                .name(domain.getName())
                .courses(domain.getCourses())
                .build();
    }
}
