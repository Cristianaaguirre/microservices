package org.example.course.application.service;

import org.example.course.application.port.in.AddStudentIntermediate;
import org.example.course.application.port.in.AddStudentPort;
import org.example.course.application.port.out.LoadCoursePort;
import org.example.course.application.port.out.UpdateCoursePort;
import org.example.course.domain.Course;
import org.springframework.stereotype.Component;

@Component
public class AddStudentService implements AddStudentPort {

    private final LoadCoursePort loadPort;
    private final UpdateCoursePort updatePort;

    public AddStudentService(LoadCoursePort loadPort, UpdateCoursePort updatePort) {
        this.loadPort = loadPort;
        this.updatePort = updatePort;
    }

    @Override
    public void addStudent(AddStudentIntermediate intermediate) {

        Course course = loadPort.getCourse(intermediate.getCourseId());

        if(course.checkLimit())
            throw new RuntimeException("course has reached the limit of students");

        course.setStudents(course.getStudents() + 1);

        updatePort.saveCourse(course);
    }
}
