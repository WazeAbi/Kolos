package fr.kolos.business.service.exercice;

import fr.kolos.business.dto.ExerciceDto;
import fr.kolos.persistence.entity.Exercice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IExerciceService {
    List<ExerciceDto> ListExercises();
    ExerciceDto getExerciseById(final int id);
    void modifyExercice(ExerciceDto exercice, int id);
    void deleteExercice(int id);
    void createExercice(ExerciceDto exercice);
}
