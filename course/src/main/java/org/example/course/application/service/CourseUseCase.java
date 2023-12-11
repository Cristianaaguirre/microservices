package org.example.course.application.service;

import lombok.RequiredArgsConstructor;
import org.example.course.application.port.in.StudentCommand;
import org.example.course.application.port.in.InputStudentPort;
import org.example.course.application.port.out.LoadCoursePort;
import org.example.course.application.port.out.UpdateCoursePort;
import org.example.course.domain.Course;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CourseUseCase implements InputStudentPort {

    private final LoadCoursePort loadPort;
    private final UpdateCoursePort updatePort;

    @Override
    public void addCourse(Course course) {
        updatePort.saveCourse(course);
    }

    @Override
    public void addStudent(StudentCommand intermediate) {

        Course course = loadPort.getCourse(intermediate.getCourseId());

        course.checkStudent(intermediate.getCourseId());

        updatePort.saveCourse(course);
    }

    @Override
    public Course getCourse(Long id) {
        return loadPort.getCourse(id);
    }

    @Override
    public List<Course> getCourses() {
        return loadPort.getCourses();
    }
}
