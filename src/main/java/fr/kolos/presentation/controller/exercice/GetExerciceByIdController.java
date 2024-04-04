package fr.kolos.presentation.controller.exercice;

import fr.kolos.business.dto.ExerciceDto;
import fr.kolos.business.service.exercice.IExerciceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetExerciceByIdController {
    private IExerciceService exerciceService;

    @GetMapping("/exercice/{id}")
    public ExerciceDto getExerciseById(@PathVariable Integer id) {
        return exerciceService.getExerciseById(id);
    }

    @Autowired
    public void setExerciceService(IExerciceService exerciceService) {
        this.exerciceService = exerciceService;
    }
}
