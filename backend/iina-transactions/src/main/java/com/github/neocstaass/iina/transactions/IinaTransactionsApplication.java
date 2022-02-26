package com.github.neocstaass.iina.transactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EntityScan(basePackages ={"com.github.neocstaass.iina.models"})
public class IinaTransactionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(IinaTransactionsApplication.class, args);
    }
}
