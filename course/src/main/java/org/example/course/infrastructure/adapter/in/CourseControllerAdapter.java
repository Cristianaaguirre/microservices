package org.example.course.infrastructure.adapter.in;

import lombok.RequiredArgsConstructor;
import org.example.course.application.port.in.InputCoursePort;
import org.example.course.application.port.in.StudentCommand;
import org.example.course.domain.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/course")
@RequiredArgsConstructor
public class CourseControllerAdapter {

    private final InputCoursePort inputPort;

    @PostMapping(path = "/create-course")
    public ResponseEntity<?> createCourse(@RequestBody Course course) {
        inputPort.addCourse(course);
        return ResponseEntity.status(200).build();
    }

    @GetMapping(path = "/get-course/{studentId}")
    public ResponseEntity<?> getCourse(@PathVariable Long studentId) {
        return ResponseEntity.status(200).body(inputPort.getCourse(studentId));
    }

    @GetMapping(path = "/get-courses")
    public ResponseEntity<?> getCourses() {
        return ResponseEntity.status(200).body(inputPort.getCourses());
    }

    @GetMapping(path = "/get-courses-by-ids")
    public ResponseEntity<?> getCoursesByIds(@RequestParam List<Long> ids) {
        return ResponseEntity.status(200).body(inputPort.getCourses(ids));
    }

    @PostMapping(path = "/add-student/{courseId}/{studentId}")
    public ResponseEntity<?> addStudent(@PathVariable Long courseId, @PathVariable Long studentId) {
        inputPort.addStudent(
            StudentCommand.builder()
                    .courseId(courseId)
                    .studentId(studentId)
                    .build()
        );
        return ResponseEntity.status(200).build();
    }

    @GetMapping(path = "/get-student-by-id/{courseId}")
    public ResponseEntity<?> getStudentsById(@PathVariable Long courseId) {
        return ResponseEntity.status(200).body(inputPort.getStudents(courseId));
    }
}
