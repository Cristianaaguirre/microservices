package org.example.students.application.port.in;

import lombok.Data;

@Data
public class AddCourseCommand {

    private String courseName;
    private Long studentId;
}
