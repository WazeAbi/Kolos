package fr.kolos.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Base64;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import fr.kolos.business.dto.UserDto;
import fr.kolos.business.service.user.IUserService;
import fr.kolos.persistence.repository.IUserRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
class UserTestIT {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	private static UserDto user = new UserDto();

	@Autowired
	private IUserRepository repo;
	
	@Autowired
	private IUserService service;

	@BeforeEach
	public void setUpTestData() {
		repo.deleteAll();
		UserDto user1 = new UserDto();
		user1.setEmail("email1");
		user1.setUsername("username1");
		user1.setRoleUser("ADMIN");
		user1.setPassword("Password1!");

		
		service.postUser(user1);
	}

	@BeforeAll
	static void init() {
		user.setEmail("email");
		user.setUsername("username");
		user.setRoleUser("USER");
		user.setPassword("Password1!");
	}
	
	private String getToken() {
        String credentials = "email1:Password1!";
        String base64Credentials = Base64.getEncoder().encodeToString(credentials.getBytes());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);

        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity(
                "http://localhost:" + port + "/login",
                new HttpEntity<>(headers),
                String.class);

        return responseEntity.getBody();
    }

	@Test
	@Order(1)
	void testGetUserByIdEndpoint() {
		try {
			HttpHeaders headers = new HttpHeaders();
	        headers.setBearerAuth(getToken());
	        HttpEntity<UserDto> requestEntity = new HttpEntity<>(headers);

			ResponseEntity<String> responseEntity = this.restTemplate.exchange(
	                "http://localhost:" + port + "/users/1",
	                HttpMethod.GET,
	                requestEntity,
	                String.class
	        );

	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		} catch (Exception e) {
			fail(e);
		}
	}
	
	@Test
	@Order(2)
	void testGetUsersEndpoint() {
		try {
			HttpHeaders headers = new HttpHeaders();
	        headers.setBearerAuth(getToken());
	        HttpEntity<UserDto> requestEntity = new HttpEntity<>(headers);

			ResponseEntity<String> responseEntity = this.restTemplate.exchange(
	                "http://localhost:" + port + "/users",
	                HttpMethod.GET,
	                requestEntity,
	                String.class
	        );

	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		} catch (Exception e) {
			fail(e);
		}
	}

	@Test
	@Order(3)
	void testRegisterEndpoint() {
		try {
			ResponseEntity<String> response = this.restTemplate.postForEntity("http://localhost:" + port + "/register",
					user, String.class);

			assertEquals(HttpStatus.OK, response.getStatusCode());
		} catch (Exception e) {
			fail(e);
		}
	}
	
	@Test
	@Order(4)
	void testPutUserEndpoint() {
		try {
			HttpHeaders headers = new HttpHeaders();
	        headers.setBearerAuth(getToken());
	        UserDto user1 = new UserDto();
	        user1.setIdUser(5);
			user1.setEmail("email1");
			user1.setUsername("username1");
			user1.setRoleUser("ADMIN");
			user1.setPassword("Password1!");
	        HttpEntity<UserDto> requestEntity = new HttpEntity<>(user1,headers);

			ResponseEntity<String> responseEntity = this.restTemplate.exchange(
	                "http://localhost:" + port + "/users",
	                HttpMethod.PUT,
	                requestEntity,
	                String.class
	        );

	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		} catch (Exception e) {
			fail(e);
		}
	}



	@Test
	@Order(5)
	void testDeleteUserEndpoint() {
		try {
			HttpHeaders headers = new HttpHeaders();
	        headers.setBearerAuth(getToken());
	        HttpEntity<UserDto> requestEntity = new HttpEntity<>(user, headers);

			ResponseEntity<String> responseEntity = this.restTemplate.exchange(
	                "http://localhost:" + port + "/users",
	                HttpMethod.DELETE,
	                requestEntity,
	                String.class
	        );

	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		} catch (Exception e) {
			fail(e);
		}
	}

}
