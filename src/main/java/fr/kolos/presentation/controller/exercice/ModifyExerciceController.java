package fr.kolos.presentation.controller.exercice;

import fr.kolos.business.dto.ExerciceDto;
import fr.kolos.business.service.exercice.IExerciceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModifyExerciceController {
    private IExerciceService exerciceService;

    @PutMapping("/exercice/{id}")
    public void modifyExercice(@PathVariable Integer id, @RequestBody ExerciceDto exerciceDto) {
        exerciceService.modifyExercice(exerciceDto, id);
    }

    @Autowired
    public void setExerciceService(IExerciceService exerciceService) {
        this.exerciceService = exerciceService;
    }
}
