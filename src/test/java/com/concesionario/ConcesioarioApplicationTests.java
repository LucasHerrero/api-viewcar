package com.concesionario;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ConcesionarioApplicationTests {

	// Puerto
	private static final int PORT = 8080;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetModels() {
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + PORT + "/api/v1/models", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void testGetModel() {
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + PORT + "/api/v1/models/1", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void testGetModelNotFound() {
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + PORT + "/api/v1/models/100", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void testGetBrands() {
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + PORT + "/api/v1/brands", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void testGetBrand() {
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + PORT + "/api/v1/brands/1", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void testGetBrandNotFound() {
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + PORT + "/api/v1/brands/100", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
}