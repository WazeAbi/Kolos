package fr.kolos.presentation.controller.exercice;

import fr.kolos.business.dto.ExerciceDto;
import fr.kolos.business.service.exercice.IExerciceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateExerciceController {
    private IExerciceService exerciceService;

    @PostMapping("/exercice")
    public void createExercice(@RequestBody ExerciceDto exercice) {
        exerciceService.createExercice(exercice);
    }

    @Autowired
    public void setExerciceService(IExerciceService exerciceService) {
        this.exerciceService = exerciceService;
    }
}
