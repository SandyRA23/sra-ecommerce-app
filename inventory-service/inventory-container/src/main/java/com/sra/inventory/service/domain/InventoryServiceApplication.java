package com.sra.inventory.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "com.sra.inventory.service.dataaccess", "com.sra.dataaccess" })
@EntityScan(basePackages = { "com.sra.inventory.service.dataaccess", "com.sra.dataaccess"})
@SpringBootApplication(scanBasePackages = "com.sra")

public class InventoryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
}