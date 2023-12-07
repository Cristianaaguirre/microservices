package org.example.students.adapter.in;

import lombok.RequiredArgsConstructor;
import org.example.students.application.port.in.CourseCommand;
import org.example.students.application.port.in.InputStudentPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/student")
@RequiredArgsConstructor
public class StudentsControllerAdapter {

    private final InputStudentPort inputPort;

    @GetMapping(path = "/get-student/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(inputPort.getStudent(id));
    }

    @GetMapping(path = "/get-students")
    public ResponseEntity<?> getStudents() {
        return ResponseEntity.status(200).body(inputPort.getStudents());
    }

    @PostMapping(path = "/add-course/{studentId}/{courseId}")
    public ResponseEntity<?> addCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        inputPort.addCourse(
                CourseCommand.builder()
                        .studentId(studentId)
                        .courseId(courseId)
                        .build()
        );
        return ResponseEntity.status(200).build();
    }
}
