package org.example.course.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Course {

    private Long id;
    private String name;
    private String professor;
    private List<String> students;

    public void checkStudent(String name) {

        if(students.size() == 20 || students.contains(name)) {
            throw new RuntimeException("No se puede agregar a un estudiante");
        }

        students.add(name);
    }

}
