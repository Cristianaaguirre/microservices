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
    private List<Long> students;

    public Course() {}

    public Course(Long id, String name, String professor, List<Long> students) {
        this.id = id;
        this.name = name;
        this.professor = professor;
        this.students = students;
    }

    public void checkStudent(Long id) {

        if(students.size() == 20 || students.contains(id)) {
            throw new RuntimeException("No se puede agregar a un estudiante");
        }

        students.add(id);
    }

}
