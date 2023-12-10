package org.example.students.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "student")
@Builder
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
}
