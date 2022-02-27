package com.github.neocstaass.iina.dashboards.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    @GetMapping("get-dashboard")
    public String getDashboard(@RequestParam(name = "event-id") String eventID) {
        return String.format("Dashboard of %s", eventID);
    }
}
