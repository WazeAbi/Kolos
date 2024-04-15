package fr.kolos.presentation.controller.exercise;

import fr.kolos.business.dto.ExerciseDto;
import fr.kolos.business.service.exercise.IExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetExerciseByIdController {
    private IExerciseService exerciseService;

    @GetMapping("/exercise/{id}")
    public ExerciseDto getExerciseById(@PathVariable Integer id) {
        return exerciseService.getExerciseById(id);
    }

    @Autowired
    public void setExerciseService(IExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }
}
