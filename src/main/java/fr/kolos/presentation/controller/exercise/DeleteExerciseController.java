package fr.kolos.presentation.controller.exercise;

import fr.kolos.business.dto.ExerciseDto;
import fr.kolos.business.service.exercise.IExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DeleteExerciseController {
	
	private IExerciseService exerciseService;

	@DeleteMapping("/exercises")
	public void deleteExercise(@RequestBody final ExerciseDto exerciseDto) {
		exerciseService.deleteExercise(exerciseDto);
	}

	@Autowired
	public void setExerciseService(IExerciseService exerciseService) {
		this.exerciseService = exerciseService;
	}
}
