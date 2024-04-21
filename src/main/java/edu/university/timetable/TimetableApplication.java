package edu.university.timetable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TimetableApplication implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").
				allowedOrigins("http://localhost:4200").
				allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS").
				allowedHeaders("*").
				allowCredentials(true);
	}

	public static void main(String[] args) {
		SpringApplication.run(TimetableApplication.class, args);
	}

}
