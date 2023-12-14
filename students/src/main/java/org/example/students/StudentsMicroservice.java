package org.example.students;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class StudentsMicroservice {

    public static void main(String[] args) {
        SpringApplication.run(StudentsMicroservice.class, args);
    }

}
