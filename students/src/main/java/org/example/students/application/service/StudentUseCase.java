package org.example.students.application.service;

import lombok.RequiredArgsConstructor;
import org.example.students.application.port.in.InputStudentPort;
import org.example.students.application.port.in.CourseCommand;
import org.example.students.application.port.out.LoadStudentPort;
import org.example.students.application.port.out.UpdateStudentPort;
import org.example.students.domain.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentUseCase implements InputStudentPort {

    private final LoadStudentPort loadPort;
    private final UpdateStudentPort updatePort;

    @Override
    public void addCourse(CourseCommand course) {

        Student student = loadPort.getStudent(course.getStudentId());

        student.checkCourse(course.getCourseId());

        updatePort.saveStudent(student);
    }

    @Override
    public Student getStudent(Long id) {
        return loadPort.getStudent(id);
    }

    @Override
    public List<Student> getStudents() {
        return loadPort.getStudents();
    }


}
