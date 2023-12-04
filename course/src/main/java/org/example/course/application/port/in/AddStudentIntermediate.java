package org.example.course.application.port.in;

public class AddStudentIntermediate {

    private Long courseId;

    public AddStudentIntermediate() {}

    public AddStudentIntermediate(Long courseId) {
        this.courseId = courseId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
