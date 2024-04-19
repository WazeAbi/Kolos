package fr.kolos.presentation.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.kolos.business.dto.UserDto;
import fr.kolos.business.service.user.IUserService;


/**
 * Controller class for handling requests to retrieve a user by ID.
 */
@RestController
@CrossOrigin
public class GetUserByIdController {

	private IUserService service;

	/**
	 * Retrieves a user by ID.
	 *
	 * @param id The ID of the user to retrieve.
	 * @return The DTO representing the retrieved user.
	 */
	@GetMapping("/users/{id}")
	public UserDto getUserById(@PathVariable final int id) {
		return service.getUserById(id);
	}

	/**
	 * Sets the user service for this controller.
	 *
	 * @param service The user service to be set.
	 */
	@Autowired
	public void setService(IUserService service) {
		this.service = service;
	}
}