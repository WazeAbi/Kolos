package fr.kolos.presentation.controller.muscle;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.kolos.business.dto.MuscleDto;
import fr.kolos.business.service.muscle.IMuscleService;

@RestController
@CrossOrigin
public class PostMuscleController {

    private IMuscleService service;

    /**
     * @param muscleDto
     * @return
     */
    @PostMapping("/muscles")
    public MuscleDto PostMuscle(@RequestBody final MuscleDto muscleDto) {
        return service.PostMuscle(muscleDto);
    }

    public IMuscleService getService() {
        return service;
    }

    public void setService(IMuscleService service) {
        this.service = service;
    }

}
