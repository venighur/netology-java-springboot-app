package ru.netology.springbootapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringbootappApplicationTests {
	@Autowired
	TestRestTemplate restTemplate;

	private static final GenericContainer<?> devapp = new GenericContainer<>("devapp:latest")
			.withExposedPorts(8080);
	private static final GenericContainer<?> prodapp = new GenericContainer<>("prodapp:latest")
			.withExposedPorts(8081);

	@BeforeAll
	public static void setUp() {
		devapp.start();
		prodapp.start();
	}

	@Test
	void devCheck() {
		// arrange
		String expected = "Current profile is dev";

		//act
		String result = restTemplate.getForEntity("http://localhost:" + devapp.getMappedPort(8080) + "/profile", String.class).getBody();

		// assert
		Assertions.assertEquals(expected, result);
	}

	@Test
	void prodCheck() {
		// arrange
		String expected = "Current profile is production";

		//act
		String result = restTemplate.getForEntity("http://localhost:" + prodapp.getMappedPort(8081) + "/profile", String.class).getBody();

		// assert
		Assertions.assertEquals(expected, result);
	}
}
