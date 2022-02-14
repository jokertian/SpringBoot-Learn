package com.jokertian.rediscahce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisCahceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisCahceApplication.class, args);
    }

}
