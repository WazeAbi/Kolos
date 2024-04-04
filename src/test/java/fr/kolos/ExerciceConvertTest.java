package fr.kolos;

import fr.kolos.business.convert.ExerciceConvert;
import fr.kolos.business.dto.ExerciceDto;
import fr.kolos.persistence.entity.Exercice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExerciceConvertTest {
    private static ExerciceConvert exerciceConvert = ExerciceConvert.getInstance();
    @Test
    public void testConvertDtoToEntity(){
        ExerciceDto exerciceDto = new ExerciceDto();
        exerciceDto.setIdEx(1);
        exerciceDto.setNameExercice("Marteau");
        exerciceDto.setDescription("Les gros muscles");
        exerciceDto.setUrlImage("test/test");
        Exercice exercice = exerciceConvert.convertDtoToEntity(exerciceDto);
        assertEquals(Exercice.class,exercice.getClass());
        assertEquals("Marteau",exercice.getNameExercice());
        assertEquals("Les gros muscles",exercice.getDescription());
        assertEquals("test/test",exercice.getUrlImage());
    }
    @Test
    public void TestConvertEntityToDto(){
        Exercice exercice = new Exercice();
        exercice.setIdEx(1);
        exercice.setNameExercice("Curl");
        exercice.setDescription("Les petits muscles");
        exercice.setUrlImage("test/test");
        ExerciceDto exerciceDto = exerciceConvert.convertEntityToDto(exercice);
        assertEquals(ExerciceDto.class,exerciceDto.getClass());
        assertEquals("Curl",exerciceDto.getNameExercice());
        assertEquals("Les petits muscles",exercice.getDescription());
        assertEquals("test/test",exerciceDto.getUrlImage());
    }
    @Test
    void TestConvertListEntityToListDto(){
        List<Exercice> listExercice = new ArrayList<>();
        Exercice exercice = new Exercice();
        Exercice exercice1 = new Exercice();
        exercice.setIdEx(1);
        exercice1.setIdEx(2);
        listExercice.add(exercice);
        listExercice.add(exercice1);
        List<ExerciceDto>  listExerciceDto = exerciceConvert.getInstance().convertListEntityToListDto(listExercice);
        assertEquals(listExerciceDto.size(),listExercice.size());
    }
    @Test
    void TestConvertListDtoToListEntity(){
        List<ExerciceDto> ListExerciceDto = new ArrayList<>();
        ExerciceDto exerciceDto1 = new ExerciceDto();
        ExerciceDto exerciceDto2 = new ExerciceDto();
        exerciceDto1.setIdEx(1);
        exerciceDto2.setIdEx(2);
        ListExerciceDto.add(exerciceDto1);
        ListExerciceDto.add(exerciceDto2);
        List<Exercice> listExercice = exerciceConvert.getInstance().convertListDtoToListEntity(ListExerciceDto);
        assertEquals(listExercice.size(),ListExerciceDto.size());
    }
}
