package org.example.students.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "student")
@Builder
@Getter
@Setter
public class StudentEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ElementCollection(targetClass = Long.class)
    @CollectionTable(
            name = "courses",
            joinColumns = @JoinColumn(name = "course_id")
    )
    @Column(name = "course")
    private List<Long> courses;

    public StudentEntity() {}

    public StudentEntity(Long id, String name, List<Long> courses) {
        this.id = id;
        this.name = name;
        this.courses = courses;
    }
}
