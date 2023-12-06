package org.example.course.adapter.in;

import lombok.RequiredArgsConstructor;
import org.example.course.application.port.in.AddStudentPort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/course")
@RequiredArgsConstructor
public class CourseController {

    private final AddStudentPort addStudentPort;


}
