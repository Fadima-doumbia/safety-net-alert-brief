package com.brief.safetyNetAlerts;

import com.brief.safetyNetAlerts.utils.ReadJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SafetyNetAlertsApplication {
	@Autowired
	ReadJson readJson;
	public static void main(String[] args) {
		SpringApplication.run(SafetyNetAlertsApplication.class, args);
	}

}
