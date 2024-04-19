package fr.kolos.service;

import fr.kolos.business.dto.ExerciseDto;
import fr.kolos.business.service.exercise.IExerciseService;
import fr.kolos.persistence.entity.Exercise;
import fr.kolos.persistence.repository.IExerciseRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExerciseServiceTest {
    @Mock
    private IExerciseRepository repository;
    @InjectMocks
    private IExerciseService service;

    private Exercise exercise;
    private ExerciseDto exerciseDto;

    @Test
    void getExercices() {
        try {
            service.ListExercises();
            verify(repository, times(1)).findAll();
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void getExerciseById() {
        try {
            when(repository.getReferenceById(1)).thenReturn(exercise);
            service.getExerciseById(1);
            verify(repository, times(1)).getReferenceById(1);
        } catch (Exception e) {
            fail(e);
        }
    }
    @Test
    void saveExercise() {
        try {
            when(repository.save(any(Exercise.class))).thenReturn(exercise);
            service.saveExercise(exerciseDto);
            verify(repository, times(1)).save(any(Exercise.class));
        }   catch (Exception e) {
            fail(e);
        }
    }
    @Test
    void deleteExercise() {
        try {
            service.deleteExercise(exerciseDto);
            verify(repository, times(1)).delete(any(Exercise.class));
        } catch (Exception e) {
            fail(e);
        }
    }
}
