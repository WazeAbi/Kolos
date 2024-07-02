package fr.kolos.integration;

import fr.kolos.business.dto.UserDto;
import fr.kolos.business.service.user.IUserService;
import fr.kolos.persistence.repository.IUserRepository;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import fr.kolos.business.dto.ExerciseDto;
import fr.kolos.business.service.exercise.IExerciseService;
import fr.kolos.persistence.repository.IExerciseRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.springframework.http.HttpHeaders;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)
class ExerciseTestIntegration {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    private static ExerciseDto exercise = new ExerciseDto();

    @Autowired
    private IUserRepository repositoryUser;
    @Autowired
    private IUserService serviceUser;
    @Autowired
    private IExerciseRepository repository;

    @Autowired
    private IExerciseService service;

    @BeforeEach
    public void setUpTestData() {
        repositoryUser.deleteAll();
        UserDto user1 = new UserDto();
        user1.setEmail("email1");
        user1.setUsername("username1");
        user1.setRoleUser("ADMIN");
        user1.setPassword("Password1!");


        serviceUser.postUser(user1);
    }

    @BeforeEach
    public void setUpTestDate() {
        repository.deleteAll();
        ExerciseDto exercise1 = new ExerciseDto();
        exercise1.setNameExercise("test exercise 1");
        exercise1.setDescription("Test exercise 1");
        exercise1.setUrlImage("test Url 1");

        service.saveExercise(exercise1);

    }

    @BeforeAll
    static void init() {
        exercise.setNameExercise("Test");
        exercise.setDescription("Test exercise ");
        exercise.setUrlImage("test Url ");
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
    void testGetAllExercises() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(getToken());
            HttpEntity<String> requestEntity = new HttpEntity<>(headers);
            ResponseEntity<String> responseEntity = this.restTemplate.exchange(
                    "http://localhost:" + port + "/exercises",
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
    void testGetExerciseById() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(getToken());
            HttpEntity<String> requestEntity = new HttpEntity<>(headers);
            ResponseEntity<String> responseEntity = this.restTemplate.exchange(
                    "http://localhost:" + port + "/exercise/2",
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
    void testModifyExercise() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(getToken());
            ExerciseDto exerciseDto = new ExerciseDto();
            exerciseDto.setIdEx(4);
            exerciseDto.setNameExercise("test exercise 2");
            exerciseDto.setDescription("Test exercise 2");
            exerciseDto.setUrlImage("test Url 2");
            HttpEntity<ExerciseDto> requestEntity = new HttpEntity<>(exerciseDto, headers);
            ResponseEntity<String> responseEntity = this.restTemplate.exchange(
                    "http://localhost:" + port + "/exercises",
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
    @Order(4)
    void saveExercise() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(getToken());
            ExerciseDto exerciseDto = new ExerciseDto();
            exerciseDto.setNameExercise("test exercise 2");
            exerciseDto.setDescription("Test exercise 2");
            exerciseDto.setUrlImage("test Url 2");
            HttpEntity<ExerciseDto> requestEntity = new HttpEntity<>(exerciseDto, headers);
            ResponseEntity<String> responseEntity = this.restTemplate.exchange(
                    "http://localhost:" + port + "/exercises",
                    HttpMethod.POST,
                    requestEntity,
                    String.class
            );

        } catch (Exception e) {
            fail(e);
        }
    }
    @Test
    @Order(5)
    void testDeleteExercise() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(getToken());
            HttpEntity<ExerciseDto> requestEntity = new HttpEntity<>(exercise, headers);
            ResponseEntity<String> responseEntity = this.restTemplate.exchange(
                    "http://localhost:" + port + "/exercise",
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
