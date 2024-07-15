package fr.kolos.business.service.exercise;

import fr.kolos.business.dto.ExerciseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IExerciseService {
    List<ExerciseDto> listExercises();
    ExerciseDto getExerciseById(final int id);
    void deleteExercise(ExerciseDto exerciseDto);
    void saveExercise(ExerciseDto exerciseDto);
}
