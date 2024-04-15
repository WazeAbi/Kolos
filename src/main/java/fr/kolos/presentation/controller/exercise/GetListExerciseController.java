package fr.kolos.presentation.controller.exercise;

import fr.kolos.business.dto.ExerciseDto;
import fr.kolos.business.service.exercise.IExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetListExerciseController {
    private IExerciseService exerciseService;

    @GetMapping("/exercise")
    public List<ExerciseDto> ListExercises() {
        return exerciseService.ListExercises();
    }

    @Autowired
    public void setExerciseService(IExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }
}
