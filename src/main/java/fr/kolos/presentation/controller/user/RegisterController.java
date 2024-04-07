package fr.kolos.presentation.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.kolos.business.dto.UserDto;
import fr.kolos.business.service.user.IUserService;

/**
 * Controller class for handling requests to create a new user.
 */
@RestController
@CrossOrigin
public class RegisterController {

	private IUserService service;

	/**
	 * Creates a new user.
	 *
	 * @param userDto The DTO representing the user to be created.
	 * @return The DTO representing the newly created user.
	 * @throws IllegalAccessException
	 */
	@PostMapping("/register")
	public UserDto postUser(@RequestBody final UserDto userDto) {
		return service.postUser(userDto);
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
