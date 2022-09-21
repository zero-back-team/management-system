package com.zero.mealkitservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MealkitServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MealkitServiceApplication.class, args);
    }

}
