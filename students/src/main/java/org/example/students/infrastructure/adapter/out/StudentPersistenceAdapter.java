package org.example.students.infrastructure.adapter.out;

import lombok.RequiredArgsConstructor;
import org.example.students.application.port.out.LoadStudentPort;
import org.example.students.application.port.out.UpdateStudentPort;
import org.example.students.domain.Student;
import org.example.students.infrastructure.repositories.SpringStudentRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StudentPersistenceAdapter implements LoadStudentPort, UpdateStudentPort {

    private final SpringStudentRepository repository;

    @Override
    public Student getStudent(Long id) {
        return Optional
                .of(repository.getReferenceById(id))
                .map(StudentMapper::entityToDomain)
                .orElseThrow();
    }

    @Override
    public List<Student> getStudents() {
        return repository.findAll()
                .stream()
                .map(StudentMapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void saveStudent(Student student) {
        repository.save(StudentMapper.domainToEntity(student));
    }
}
