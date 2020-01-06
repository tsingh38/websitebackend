package com.lastrada.website.lastrada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//@ComponentScan({ "com.lastrada.website.lastrada.*" })
@SpringBootApplication
public class LastradaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LastradaApplication.class, args);
	}

}
