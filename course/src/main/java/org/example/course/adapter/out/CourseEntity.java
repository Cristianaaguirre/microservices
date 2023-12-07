package org.example.course.adapter.out;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "courses")
@Builder
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

}
