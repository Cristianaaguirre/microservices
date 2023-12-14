package org.example.students.infrastructure.adapter.out;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Course {

    private Long id;
    private String name;
    private String professor;

    public Course() {}
}
