package org.example.students.infrastructure.adapter.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Course {

    private Long id;
    private String name;
    private String professor;

    public Course() {}
}
