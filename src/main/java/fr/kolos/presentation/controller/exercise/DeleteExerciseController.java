package fr.kolos.presentation.controller.exercise;

import fr.kolos.business.service.exercise.IExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteExerciseController {
    private IExerciseService exerciseService;
    @DeleteMapping("/exercise/{id}")
    public void deleteExercise(@PathVariable Integer id ){
        exerciseService.deleteExercise(id);
    }
    @Autowired
    public void setExerciseService(IExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }
}
