package fr.kolos.presentation.controller.muscle;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import fr.kolos.business.dto.MuscleDto;
import fr.kolos.persistence.repository.IMuscleRepository;

public class PutMuscleController {

    private IMuscleRepository service;

    public IMuscleRepository getService() {
        return service;
    }

    public void setService(IMuscleRepository service) {
        this.service = service;
    }

    @PutMapping("/muscles")
    public MuscleDto PutMuscle(@RequestBody final MuscleDto muscleDto) {
        return ((PutMuscleController) service).PutMuscle(muscleDto);

    }

}
