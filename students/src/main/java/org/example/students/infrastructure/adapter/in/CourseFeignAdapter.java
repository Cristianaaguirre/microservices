package org.example.students.infrastructure.adapter.in;

import org.example.students.infrastructure.adapter.out.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "msvc-course", url = "localhost:8080/api/course")
public interface CourseFeignAdapter {

    @GetMapping(path = "/get-courses-by-ids")
    List<Course> getCoursesByIds(@RequestParam List<Long> ids);
}
