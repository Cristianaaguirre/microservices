package org.example.course.infrastructure.repositories;

import org.example.course.infrastructure.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringCourseRepository extends JpaRepository<CourseEntity, Long> {
}
