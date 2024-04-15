package fr.kolos.presentation.controller.exercise;

import fr.kolos.business.dto.ExerciseDto;
import fr.kolos.business.service.exercise.IExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateExerciseController {
    private IExerciseService exerciseService;

    @PostMapping("/exercise")
    public void createExercise(@RequestBody ExerciseDto exercise) {
        exerciseService.createExercise(exercise);
    }

    @Autowired
    public void setExerciseService(IExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }
}
