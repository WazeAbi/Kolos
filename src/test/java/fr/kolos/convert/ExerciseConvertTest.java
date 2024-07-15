package fr.kolos.convert;

import fr.kolos.business.convert.ExerciseConvert;
import fr.kolos.business.dto.ExerciseDto;
import fr.kolos.persistence.entity.Exercise;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExerciseConvertTest {
    private static ExerciseConvert exerciseConvert = ExerciseConvert.getInstance();
    @Test
    public void testConvertDtoToEntity(){
        ExerciseDto exerciseDto = new ExerciseDto();
        exerciseDto.setIdEx(1);
        exerciseDto.setNameExercise("Marteau");
        exerciseDto.setDescription("Les gros muscles");
        exerciseDto.setUrlImage("test/test");
        Exercise exercise = exerciseConvert.convertDtoToEntity(exerciseDto);
        assertEquals(Exercise.class,exercise.getClass());
        assertEquals("Marteau",exercise.getNameExercise());
        assertEquals("Les gros muscles",exercise.getDescription());
        assertEquals("test/test",exercise.getUrlImage());
    }
    @Test
    public void TestConvertEntityToDto(){
        Exercise exercise = new Exercise();
        exercise.setIdExercise(1);
        exercise.setNameExercise("Curl");
        exercise.setDescription("Les petits muscles");
        exercise.setUrlImage("test/test");
        ExerciseDto exerciseDto = exerciseConvert.convertEntityToDto(exercise);
        assertEquals(ExerciseDto.class,exerciseDto.getClass());
        assertEquals("Curl",exerciseDto.getNameExercise());
        assertEquals("Les petits muscles",exercise.getDescription());
        assertEquals("test/test",exerciseDto.getUrlImage());
    }
    @Test
    void TestConvertListEntityToListDto(){
        List<Exercise> listExercise = new ArrayList<>();
        Exercise exercise = new Exercise();
        Exercise exercise1 = new Exercise();
        exercise.setIdExercise(1);
        exercise1.setIdExercise(2);
        listExercise.add(exercise);
        listExercise.add(exercise1);
        List<ExerciseDto>  listExerciseDto = exerciseConvert.convertListEntityToListDto(listExercise);
        assertEquals(listExerciseDto.size(),listExercise.size());
    }
    @Test
    void TestConvertListDtoToListEntity(){
        List<ExerciseDto> ListExerciseDto = new ArrayList<>();
        ExerciseDto exerciseDto1 = new ExerciseDto();
        ExerciseDto exerciseDto2 = new ExerciseDto();
        exerciseDto1.setIdEx(1);
        exerciseDto2.setIdEx(2);
        ListExerciseDto.add(exerciseDto1);
        ListExerciseDto.add(exerciseDto2);
        List<Exercise> listExercise = exerciseConvert.convertListDtoToListEntity(ListExerciseDto);
        assertEquals(listExercise.size(),ListExerciseDto.size());
    }
}
