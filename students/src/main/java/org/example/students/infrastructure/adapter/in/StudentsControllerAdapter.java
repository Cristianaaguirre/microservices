package org.example.students.infrastructure.adapter.in;

import lombok.RequiredArgsConstructor;
import org.example.students.application.port.in.CourseCommand;
import org.example.students.application.port.in.InputStudentPort;
import org.example.students.domain.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/student")
@RequiredArgsConstructor
public class StudentsControllerAdapter {

    private final InputStudentPort inputPort;

    @PostMapping(path = "/create-student")
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        inputPort.createStudent(student);
        return ResponseEntity.status(200).build();
    }

    @GetMapping(path = "/get-student/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(inputPort.getStudent(id));
    }

    @GetMapping(path = "/get-students")
    public ResponseEntity<?> getStudents() {
        return ResponseEntity.status(200).body(inputPort.getStudents());
    }

    @GetMapping(path = "/get-students-by-ids")
    public ResponseEntity<?> getStudentsByIds(@RequestParam List<Long> ids) {
        return ResponseEntity.status(200).body(inputPort.getStudents(ids));
    }

    @GetMapping(path = "/get-courses-by-id/{id}")
    public ResponseEntity<?> getCoursesById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(inputPort.getCourses(id));
    }

    @PostMapping(path = "/add-course")
    public ResponseEntity<?> addCourse(@RequestBody CourseCommand command) {
        inputPort.addCourse(command);
        return ResponseEntity.status(200).build();
    }


}
