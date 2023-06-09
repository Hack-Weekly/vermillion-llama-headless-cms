package com.llama.headlessCMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HeadlessCmsApplication {

	public static void main(String[] args) {

		try {
			SpringApplication.run(HeadlessCmsApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
