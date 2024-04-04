package fr.kolos.presentation.controller.muscle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.kolos.business.dto.MuscleDto;
import fr.kolos.business.service.muscle.IMuscleService;

/**
 * Controller class for handling requests to delete mucles.
 */
@RestController
@CrossOrigin
public class DeleteMuscleController {

	private IMuscleService service;

	public IMuscleService getService() {
		return service;
	}

	@Autowired
	public void setService(IMuscleService service) {
		this.service = service;
	}

	/**
	 * Deletes a muscle using the provided muscle DTO.
	 *
	 * @param muscleDto The DTO representing the muscle to be deleted.
	 */
	@DeleteMapping("/muscles")
	public void deletemuscle(@RequestBody final MuscleDto muscleDto) {

	}

}