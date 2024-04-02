package com;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
@SpringBootTest(classes = ApplicationTests.class)
class ApplicationTests {

	@Test
	void contextLoads() {
	}

}
