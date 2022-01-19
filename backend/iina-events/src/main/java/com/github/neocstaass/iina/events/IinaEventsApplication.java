package com.github.neocstaass.iina.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class IinaEventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(IinaEventsApplication.class, args);
	}

	@GetMapping("/get-event-info")
	public String getEventInfo(@RequestParam("id") String eventID) {
		return String.format("Info about event %s", eventID);
	}
}
