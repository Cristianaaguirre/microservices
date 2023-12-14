package org.example.course.infrastructure.adapter.in;

import org.example.course.infrastructure.adapter.out.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "msvc-student", url = "localhost:8080/api/student")
public interface StudentFeignAdapter {

    @GetMapping(path = "/get-students-by-ids")
    List<Student> getStudentsByIds(@RequestParam List<Long> ids);
}
