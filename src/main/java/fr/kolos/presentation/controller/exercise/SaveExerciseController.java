package fr.kolos.presentation.controller.exercise;

import fr.kolos.business.dto.ExerciseDto;
import fr.kolos.business.service.exercise.IExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SaveExerciseController {
    private IExerciseService exerciseService;

    @PostMapping("/exercises")
    public void saveExercise(@RequestBody final ExerciseDto exercise) {
        exerciseService.saveExercise(exercise);
    }

    @Autowired
    public void setExerciseService(IExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }
}
