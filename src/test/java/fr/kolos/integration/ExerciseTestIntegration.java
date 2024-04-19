//package fr.kolos.business.service.exercise.integration;
//
//import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
//import org.junit.jupiter.api.TestMethodOrder;
//import fr.kolos.business.dto.ExerciseDto;
//import fr.kolos.business.service.exercise.IExerciseService;
//import fr.kolos.persistence.repository.IExerciseRepository;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@TestMethodOrder(OrderAnnotation.class)
//class ExerciseTestIntegration {
//    @LocalServerPort
//    private int port;
//    @Autowired
//    private TestRestTemplate restTemplate;
//    private static ExerciseDto exercise = new ExerciseDto();
//
//    @Autowired
//    private IExerciseRepository repository;
//
//    @Autowired
//    private IExerciseService service;
//    @BeforeEach
//    public void setUpTestData() {
//        repository.deleteAll();
//        UserDto user1 = new UserDto();
//        user1.setEmail("email1");
//        user1.setUsername("username1");
//        user1.setRoleUser("ADMIN");
//        user1.setPassword("Password1!");
//
//
//        service.postUser(user1);
//    }
//    @BeforeEach
//    public void setUpTestDate() {
//        repository.deleteAll();
//        ExerciseDto exercise1= new ExerciseDto();
//        exercise1.setNameExercise("test exercise 1");
//        exercise1.setDescription("Test exercise 1");
//        exercise1.setUrlImage("test Url 1");
//
//        service.saveExercise(exercise1);
//
//    }
//    @BeforeAll
//    static void init(){
//        exercise.setNameExercise("Test");
//        exercise.setDescription("Test exercise ");
//        exercise.setUrlImage("test Url ");
//    }
//private String getToken(){
//        String credentials =
//}
//
//
//}
