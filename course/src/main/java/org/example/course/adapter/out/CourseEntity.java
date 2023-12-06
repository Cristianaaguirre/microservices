package org.example.course.adapter.out;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "courses")
@Data
@Builder
public class CourseEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String professor;
    @ElementCollection(targetClass = String.class)
    @CollectionTable(
            name = "students",
            joinColumns = @JoinColumn(name = "student_id")
    )
    @Column(name = "student")
    private List<String> students;

}
