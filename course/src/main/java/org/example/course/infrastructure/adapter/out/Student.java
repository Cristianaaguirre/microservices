package org.example.course.infrastructure.adapter.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Student {

    private Long id;
    private String name;

    public Student() {}


}
