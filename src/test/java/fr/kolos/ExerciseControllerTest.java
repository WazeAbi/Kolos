package fr.kolos;

import fr.kolos.business.dto.ExerciseDto;
import fr.kolos.business.service.exercise.IExerciseService;
import fr.kolos.presentation.controller.exercise.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ExerciseControllerTest {
    @Mock
    private IExerciseService service;
    @InjectMocks
    private GetListExerciseController getListExerciseController;
    @InjectMocks
    private GetExerciseByIdController getExerciseByIdController;
    @InjectMocks
    private CreateExerciseController saveExerciseController;
    @InjectMocks
    private ModifyExerciseController modifyExerciseController;
    @InjectMocks
    private DeleteExerciseController deleteExerciseController;
    ExerciseDto exerciseDto = new ExerciseDto();
    @Test
    void getExerciseByIdController() {
        try {
            getExerciseByIdController.getExerciseById(1);
            verify(service, times(1)).getExerciseById(1);
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void saveExerciseController() {
        try {
            saveExerciseController.createExercise(exerciseDto);
            verify(service, times(1)).saveExercise(exerciseDto);
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void ModifyExerciseController() {
        try {
            modifyExerciseController.modifyExercise(exerciseDto);
            verify(service, times(1)).saveExercise(exerciseDto);
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void setDeleteExerciseController() {
        try {
            deleteExerciseController.deleteExercise(1);
            verify(service, times(1)).deleteExercise(1);
        } catch (Exception e) {
            fail(e);
        }
    }

}
