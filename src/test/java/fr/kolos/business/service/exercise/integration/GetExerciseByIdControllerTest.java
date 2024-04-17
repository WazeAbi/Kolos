package fr.kolos.business.service.exercise.integration;

import fr.kolos.business.dto.ExerciseDto;
import fr.kolos.business.service.exercise.IExerciseService;
import fr.kolos.presentation.controller.exercise.GetExerciseByIdController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GetExerciseByIdControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private IExerciseService exerciseService;

    @InjectMocks
    private GetExerciseByIdController getExerciseByIdController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(getExerciseByIdController).build();
    }

    @Test
    public void testGetExerciseById() throws Exception {
        ExerciseDto mockExerciseDto = new ExerciseDto();
        mockExerciseDto.setIdEx(1);
        mockExerciseDto.setNameExercise("Exercise 1");
        mockExerciseDto.setDescription("test");
        mockExerciseDto.setUrlImage("Incr");
        when(exerciseService.getExerciseById(1)).thenReturn(mockExerciseDto);

        mockMvc.perform(get("/exercise/1"))
                .andExpect(status().isOk());
    }
}
