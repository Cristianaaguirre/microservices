package org.example.course.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "courses")
@Builder
@Getter
@Setter
public class CourseEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String professor;
    @ElementCollection(targetClass = Long.class)
    @CollectionTable(
            name = "students",
            joinColumns = @JoinColumn(name = "student_id")
    )
    @Column(name = "student")
    private List<Long> students;

    public CourseEntity() {}

    public CourseEntity(Long id, String name, String professor, List<Long> students) {
        this.id = id;
        this.name = name;
        this.professor = professor;
        this.students = students;
    }
}
