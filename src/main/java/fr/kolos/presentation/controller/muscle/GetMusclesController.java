package fr.kolos.presentation.controller.muscle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.kolos.business.dto.MuscleDto;
import fr.kolos.business.service.muscle.IMuscleService;

/**
 * Controller class for handling requests to Get muscles.
 */
@RestController
@CrossOrigin
public class GetMusclesController{

	private IMuscleService service;

	public IMuscleService getService() {
		return service;
	}

	@Autowired
	public void setService(IMuscleService service) {
		this.service = service;
	}


    @GetMapping("/muscles")
	public List<MuscleDto> getUsers() {
		return service.getMuscles();
	}

	
	}

