package com.axonactive.training.ebookapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class EbookappApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void test_Java8_functionality_Demo() {

		String passwordUser = new BCryptPasswordEncoder().encode("aavn@123");
		System.out.println(passwordUser);
		String passwordAdmin = new BCryptPasswordEncoder().encode("aavn@admin123");
		System.out.println(passwordAdmin);
	}
}
