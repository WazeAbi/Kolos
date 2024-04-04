package fr.kolos.business.service.exercice;

import fr.kolos.business.dto.ExerciceDto;
import fr.kolos.persistence.entity.Exercice;
import org.springframework.stereotype.Service;

@Service
public interface IExerciceService {
    void modifyExercice(ExerciceDto exercice, int id);
    void deleteExercice(int id);
    void createExercice(ExerciceDto exercice);
}
