package fr.kolos.presentation.controller.exercice;

import fr.kolos.business.dto.ExerciceDto;
import fr.kolos.business.service.exercice.IExerciceService;
import fr.kolos.persistence.entity.Exercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetListExerciceController {
    private IExerciceService exerciceService;

    @GetMapping("/exercice")
    public List<ExerciceDto> ListExercises() {
        return exerciceService.ListExercises();
    }

    @Autowired
    public void setExerciceService(IExerciceService exerciceService) {
        this.exerciceService = exerciceService;
    }
}
