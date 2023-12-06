package org.example.students.application.service;

import lombok.RequiredArgsConstructor;
import org.example.students.application.port.in.AddCoursePort;
import org.example.students.application.port.in.AddCourseCommand;
import org.example.students.application.port.out.LoadStudentPort;
import org.example.students.application.port.out.UpdateStudentPort;
import org.example.students.domain.Student;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddCourseService implements AddCoursePort {

    private final LoadStudentPort loadPort;
    private final UpdateStudentPort updatePort;

    @Override
    public void addCourse(AddCourseCommand course) {

        Student student = loadPort.getStudent(course.getStudentId());

        student.checkCourse(course.getCourseName());

        updatePort.saveStudent(student);
    }

}
