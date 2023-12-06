package org.example.course.application.port.in;

import lombok.Data;

@Data
public class AddStudentCommand {

    private Long courseId;
    private String studentName;
}
