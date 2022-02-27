package com.github.neocstaass.iina.dashboards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages ={"com.github.neocstaass.iina.models"})
public class IinaDashboardsApplication {

    public static void main(String[] args) {
        SpringApplication.run(IinaDashboardsApplication.class, args);
    }

}
