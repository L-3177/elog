package com.l_3177;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class ElogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElogApplication.class, args);
        System.out.println("http://localhost:8080");
    }


}
