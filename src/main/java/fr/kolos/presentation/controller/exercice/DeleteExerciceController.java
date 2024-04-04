package fr.kolos.presentation.controller.exercice;

import fr.kolos.business.service.exercice.IExerciceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteExerciceController {
    private IExerciceService exerciceService;
    @DeleteMapping("/exercice/{id}")
    public void deleteExercice(@PathVariable Integer id ){
        exerciceService.deleteExercice(id);
    }
    @Autowired
    public void setExerciceService(IExerciceService exerciceService) {
        this.exerciceService = exerciceService;
    }
}
