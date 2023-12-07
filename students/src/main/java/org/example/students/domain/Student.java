package org.example.students.domain;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.JoinColumn;
import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
@Builder
public class Student {

    private Long id;
    private String name;
    private List<Long> courses;

    public void checkCourse(Long id) {
        if(courses.size() == 10) {
            throw new RuntimeException("No se puede tener mas de 10 cursos");
        } else {
            courses.add(id);
        }
    }

}
