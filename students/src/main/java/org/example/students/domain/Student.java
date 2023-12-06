package org.example.students.domain;

import jakarta.persistence.ElementCollection;
import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
@Builder
public class Student {

    private Long id;
    private String name;
    @ElementCollection
    private List<String> courses;

    public Student() {}

    public void checkCourse(String name) {
        if(courses.size() == 10 || courses.contains(name)) {
            throw new RuntimeException("No se puede tener mas de 10 cursos");
        } else {
            courses.add(name);
        }
    }

}
