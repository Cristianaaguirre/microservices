package org.example.course.infrastructure.adapter.in;

import org.example.course.infrastructure.adapter.out.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "msvc-student", url = "http://localhost:9898/")
public interface StudentFeignAdapter {

    @GetMapping()
    List<Student> getStudentsByIds(@RequestBody List<Long> ids);
}
