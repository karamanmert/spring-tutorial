package com.mertkaraman.springtutorial.student.config;

import com.mertkaraman.springtutorial.student.entity.StudentEntity;
import com.mertkaraman.springtutorial.student.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.APRIL;
import static java.time.Month.AUGUST;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            StudentEntity mert = new StudentEntity(
                    "mert",
                    "mert@gmail.com",
                    LocalDate.of(1995, APRIL, 1)
                    );
            StudentEntity yigit = new StudentEntity(
                    "yigit",
                    "yigit@gmail.com",
                    LocalDate.of(1988, AUGUST, 8)
                    );
            repository.saveAll(
                    List.of(mert, yigit)
            );
        };
    }
}
