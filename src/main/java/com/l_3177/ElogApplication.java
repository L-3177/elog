package com.l_3177;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElogApplication.class, args);
        System.out.println("http://localhost:8080");
    }


}
