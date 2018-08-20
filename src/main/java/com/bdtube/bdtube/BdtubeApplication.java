package com.bdtube.bdtube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class BdtubeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BdtubeApplication.class, args);
    }
}
