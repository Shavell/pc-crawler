package com.shavell.backend;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class CrawlerBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrawlerBackendApplication.class, args);
    }

}
