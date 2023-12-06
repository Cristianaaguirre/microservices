package org.example.course.application.service;

import lombok.RequiredArgsConstructor;
import org.example.course.application.port.in.AddStudentCommand;
import org.example.course.application.port.in.AddStudentPort;
import org.example.course.application.port.out.LoadCoursePort;
import org.example.course.application.port.out.UpdateCoursePort;
import org.example.course.domain.Course;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddStudentService implements AddStudentPort {

    private final LoadCoursePort loadPort;
    private final UpdateCoursePort updatePort;

    @Override
    public void addStudent(AddStudentCommand intermediate) {

        Course course = loadPort.getCourse(intermediate.getCourseId());

        course.checkStudent(intermediate.getStudentName());

        updatePort.saveCourse(course);
    }
}
