package org.example.students.application.port.in;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseCommand {

    private Long courseId;
    private Long studentId;
}
