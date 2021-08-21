package com.mertkaraman.springtutorial.location.config;

import com.mertkaraman.springtutorial.location.entity.Location;
import com.mertkaraman.springtutorial.location.repository.LocationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LocationConfig {
    //Command Line Runner is an interface. It is used to execute the code after the Spring Boot application started
    @Bean
    CommandLineRunner commandLineRunner(LocationRepository repository) {
        return args -> {

            Location loc1 = new Location(
                    "Ankara", "sincan"
            );
            Location loc2 = new Location(
                    "Samsun", "bafra"
            );
            repository.saveAll(
                    List.of(loc1, loc2)
            );

        };
    }

}
