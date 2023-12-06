package org.example.students.application.port.out;

import org.example.students.domain.Student;

public interface UpdateStudentPort {

    void saveStudent(Student student);
}
