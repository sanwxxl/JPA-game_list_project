package org.example.week09.week09_jpa_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Week09JpaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week09JpaProjectApplication.class, args);
    }

}
