package com.mertkaraman.springtutorial.student.config;

import com.mertkaraman.springtutorial.student.entity.Student;
import com.mertkaraman.springtutorial.student.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.APRIL;
import static java.time.Month.AUGUST;
//@Configuration used by Spring Containers as a source of bean definitions.
@Configuration
public class StudentConfig {
    //Command Line Runner is an interface. It is used to execute the code after the Spring Boot application started
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {

            Student mert = new Student(
                    "mert",
                    "mert@gmail.com",
                    LocalDate.of(1995, APRIL, 1)
                    );
            Student yigit = new Student(
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
