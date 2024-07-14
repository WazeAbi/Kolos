package fr.kolos.presentation.controller.muscle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.kolos.business.dto.MuscleDto;
import fr.kolos.business.service.muscle.IMuscleService;

@RestController
@CrossOrigin
public class PutMuscleController {

    private IMuscleService service;

    @Autowired
    public void setService(IMuscleService service) {
        this.service = service;
    }

    @PutMapping("/muscles")
    public MuscleDto putMuscle(@RequestBody final MuscleDto muscleDto) {
        return service.postMuscle(muscleDto);

    }

}
