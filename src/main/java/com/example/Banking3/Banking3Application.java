package com.example.Banking3;

import com.example.Banking3.Client.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class Banking3Application {

	public static void main(String[] args) {
		SpringApplication.run(Banking3Application.class, args);
	}

}
