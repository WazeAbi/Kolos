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
        exercise.setIdExercise(exerciseDto.getIdEx());
        exercise.setNameExercise(exerciseDto.getNameExercise());
        exercise.setDescription(exerciseDto.getDescription());
        exercise.setUrlImage(exerciseDto.getUrlImage());
        return exercise;
    }

    public ExerciseDto convertEntityToDto(Exercise exercise) {
        ExerciseDto exerciseDto = new ExerciseDto();
        exerciseDto.setIdEx(exercise.getIdExercise());
        exerciseDto.setNameExercise(exercise.getNameExercise());
        exerciseDto.setDescription(exercise.getDescription());
        exerciseDto.setUrlImage(exercise.getUrlImage());
        return exerciseDto;
    }
    public List<Exercise> convertListDtoToListEntity(List<ExerciseDto> ListExerciseDto){
        List<Exercise> listExercise = new ArrayList<>();
        for (ExerciseDto exerciseDto : ListExerciseDto) {
            listExercise.add(convertDtoToEntity(exerciseDto));
        }
        return listExercise;
    }
    public List<ExerciseDto> convertListEntityToListDto(List<Exercise> ListExercise){
        List<ExerciseDto> listExerciseDto = new ArrayList<>();
        for (Exercise exercise : ListExercise) {
            listExerciseDto.add(convertEntityToDto(exercise));
        }
        return listExerciseDto;
    }
}
