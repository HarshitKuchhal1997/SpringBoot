package com.example.iocanddi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
To add the package explicitely to maven so that spring will consider them we need to use below code

 @SpringBootApplication(
    scanBasePackages={"com.example.iocanddi", "com.example.util"})

 */

@SpringBootApplication
public class IocanddiApplication {
    public static void main(String[] args) {
        SpringApplication.run(IocanddiApplication.class, args);
    }

}
