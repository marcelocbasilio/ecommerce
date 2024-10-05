package com.marcelocbasilio.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("[ENCODE] -> " + passwordEncoder.encode("123456"));
		Boolean result = passwordEncoder.matches("123456", "$2a$10$61dTy/AUSRl4F4FBUad2l.ud8TIPI9ySHJ.8Ks2023k5kS8kLfgTO");
		System.out.println("[CHECK PASSWORD] -> " + result);
	}

}
