package com.example.demo1;

import java.lang.reflect.AccessFlag.Location;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo1.run.Run;

@SpringBootApplication
public class Demo1Application {

	private static final Logger log = LoggerFactory.getLogger(Demo1Application.class); 

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@Bean
	CommandLineRunner init() {
		return args -> {
			Run run = new Run(1, "Long Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, com.example.demo1.run.Location.INDOOR);
			log.info("Run: "+ run);
		};
	}



}
