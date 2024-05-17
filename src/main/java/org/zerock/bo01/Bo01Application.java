package org.zerock.bo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Bo01Application {

    public static void main(String[] args) {
        SpringApplication.run(Bo01Application.class, args);
    }

}