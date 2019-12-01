package com.plataforma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "com.plataforma.application",
        "com.plataforma.domain",
        "com.plataforma.infrastructure",
        "com.plataforma.infrastructurecross"})
@SpringBootApplication
public class PlataformaOperativaApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlataformaOperativaApplication.class, args);
    }
}
