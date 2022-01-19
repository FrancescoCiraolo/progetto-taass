package com.github.neocstaass.iina.transactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class IinaTransactionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(IinaTransactionsApplication.class, args);
    }

    @GetMapping("get-transaction-info")
    public String getEventInfo(@RequestParam("id") String eventID) {
        return String.format("Info of transaction %s", eventID);
    }
}
