package org.example.course.adapter.in;

import lombok.RequiredArgsConstructor;
import org.example.course.application.port.in.InputStudentPort;
import org.example.course.application.port.in.StudentCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/course")
@RequiredArgsConstructor
public class CourseControllerAdapter {

    private final InputStudentPort inputPort;

    @GetMapping(path = "/get-course/{studentId}")
    public ResponseEntity<?> getCourse(@PathVariable Long studentId) {
        return ResponseEntity.status(200).body(inputPort.getCourse(studentId));
    }

    @GetMapping(path = "/get-courses")
    public ResponseEntity<?> getCourses() {
        return ResponseEntity.status(200).body(inputPort.getCourses());
    }


    @GetMapping(path = "/add-student/{courseId}/{studentId}")
    public ResponseEntity<?> addStudent(@PathVariable Long courseId, @PathVariable Long studentId) {
        inputPort.addStudent(
            StudentCommand.builder()
                    .courseId(courseId)
                    .studentId(studentId)
                    .build()
        );
        return ResponseEntity.status(200).build();
    }
}
