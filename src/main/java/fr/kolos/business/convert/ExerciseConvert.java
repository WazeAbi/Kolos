package fr.kolos.business.convert;

import fr.kolos.business.dto.ExerciseDto;
import fr.kolos.persistence.entity.Exercise;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExerciseConvert {
    private static ExerciseConvert instance;

    private ExerciseConvert() {

    }

    public static ExerciseConvert getInstance() {
        if (instance == null)
            instance = new ExerciseConvert();
        return instance;

    }

    public Exercise convertDtoToEntity(ExerciseDto exerciseDto) {
        Exercise exercise = new Exercise();
        exercise.setIdEx(exerciseDto.getIdEx());
        exercise.setNameExercise(exerciseDto.getNameExercise());
        exercise.setDescription(exerciseDto.getDescription());
        exercise.setUrlImage(exerciseDto.getUrlImage());
        return exercise;
    }

    public ExerciseDto convertEntityToDto(Exercise exercise) {
        ExerciseDto exerciseDto = new ExerciseDto();
        exerciseDto.setIdEx(exercise.getIdEx());
        exerciseDto.setNameExercise(exercise.getNameExercise());
        exerciseDto.setDescription(exercise.getDescription());
        exerciseDto.setUrlImage(exercise.getUrlImage());
        return exerciseDto;
    }
    public List<Exercise> convertListDtoToListEntity(List<ExerciseDto> ListExerciseDto){
        List<Exercise> ListExercise = new ArrayList<>();
        for (ExerciseDto exerciseDto : ListExerciseDto) {
            ListExercise.add(convertDtoToEntity(exerciseDto));
        }
        return ListExercise;
    }
    public List<ExerciseDto> convertListEntityToListDto(List<Exercise> ListExercise){
        List<ExerciseDto> ListExerciseDto = new ArrayList<>();
        for (Exercise exercise : ListExercise) {
            ListExerciseDto.add(convertEntityToDto(exercise));
        }
        return ListExerciseDto;
    }
}
