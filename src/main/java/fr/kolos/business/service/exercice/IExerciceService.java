package fr.kolos.business.service.user;

import fr.kolos.business.dto.ExerciceDto;
import fr.kolos.persistence.entity.Exercice;

public interface IExerciceService {
    void modifyExercice(ExerciceDto exercice, int id);
    void deleteExercice(int id);
    void createExercice(ExerciceDto exercice);
}
