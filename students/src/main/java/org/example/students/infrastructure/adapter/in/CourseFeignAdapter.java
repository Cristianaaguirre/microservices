package org.example.students.infrastructure.adapter.in;

import org.example.students.infrastructure.adapter.out.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient
public interface CourseFeignAdapter {

    @GetMapping
    List<Course> getCoursesByIds();
}
