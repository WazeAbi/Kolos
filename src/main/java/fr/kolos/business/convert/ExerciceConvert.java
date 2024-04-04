package fr.kolos.business.convert;

import fr.kolos.business.dto.ExerciceDto;
import fr.kolos.persistence.entity.Exercice;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExerciceConvert {
    private static ExerciceConvert instance;

    private ExerciceConvert() {

    }

    public static ExerciceConvert getInstance() {
        if (instance == null)
            instance = new ExerciceConvert();
        return instance;

    }

    public Exercice convertDtoToEntity(ExerciceDto exerciceDto) {
        Exercice exercice = new Exercice();
        exercice.setIdEx(exerciceDto.getIdEx());
        exercice.setNameExercice(exerciceDto.getNameExercice());
        exercice.setDescription(exerciceDto.getDescription());
        exercice.setUrlImage(exerciceDto.getUrlImage());
        return exercice;
    }

    public ExerciceDto convertEntityToDto(Exercice exercice) {
        ExerciceDto exerciceDto = new ExerciceDto();
        exerciceDto.setIdEx(exercice.getIdEx());
        exerciceDto.setNameExercice(exercice.getNameExercice());
        exerciceDto.setDescription(exercice.getDescription());
        exerciceDto.setUrlImage(exercice.getUrlImage());
        return exerciceDto;
    }
    public List<Exercice> convertListDtoToListEntity(List<ExerciceDto> ListExerciceDto){
        List<Exercice> ListExercice = new ArrayList<>();
        for (ExerciceDto exerciceDto : ListExerciceDto) {
            ListExercice.add(convertDtoToEntity(exerciceDto));
        }
        return ListExercice;
    }
    public List<ExerciceDto> convertListEntityToListDto(List<Exercice> ListExercice){
        List<ExerciceDto> ListExerciceDto = new ArrayList<>();
        for (Exercice exercice : ListExercice) {
            ListExerciceDto.add(convertEntityToDto(exercice));
        }
        return ListExerciceDto;
    }
}
