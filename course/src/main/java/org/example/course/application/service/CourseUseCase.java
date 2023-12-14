package org.example.course.application.service;

import lombok.RequiredArgsConstructor;
import org.example.course.application.port.in.StudentCommand;
import org.example.course.application.port.in.InputCoursePort;
import org.example.course.application.port.out.LoadCoursePort;
import org.example.course.application.port.out.UpdateCoursePort;
import org.example.course.domain.Course;
import org.example.course.infrastructure.adapter.in.StudentFeignAdapter;
import org.example.course.infrastructure.adapter.out.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CourseUseCase implements InputCoursePort {

    private final LoadCoursePort loadPort;
    private final UpdateCoursePort updatePort;
    private final StudentFeignAdapter feignAdapter;

    @Override
    public void addCourse(Course course) { updatePort.saveCourse(course); }

    @Override
    public void addStudent(StudentCommand intermediate) {

        Course course = loadPort.getCourse(intermediate.getCourseId());

        course.checkStudent(intermediate.getCourseId());

        updatePort.saveCourse(course);
    }

    @Override
    public Course getCourse(Long id) { return loadPort.getCourse(id); }

    @Override
    public List<Course> getCourses() { return loadPort.getCourses(); }

    @Override
    public List<Student> getStudents(Long id) {

        Course course = loadPort.getCourse(id);

        List<Long> studentsIds = course.getStudents();

        return feignAdapter.getStudentsByIds(studentsIds);
    }


}
