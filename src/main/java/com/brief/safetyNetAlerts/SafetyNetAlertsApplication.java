package com.brief.safetyNetAlerts;

import com.brief.safetyNetAlerts.utils.ReadJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SafetyNetAlertsApplication implements CommandLineRunner {
	@Autowired
	ReadJson readJson;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SafetyNetAlertsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		readJson.readAndSaveJson();
	}
}
