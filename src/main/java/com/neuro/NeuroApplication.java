package com.neuro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class NeuroApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeuroApplication.class, args);
	}

}
