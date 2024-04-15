package fr.kolos.business.service.exercise;

import fr.kolos.business.dto.ExerciseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IExerciseService {
    List<ExerciseDto> ListExercises();
    ExerciseDto getExerciseById(final int id);
    void deleteExercise(int id);
    void saveExercise(ExerciseDto exercise);
}
