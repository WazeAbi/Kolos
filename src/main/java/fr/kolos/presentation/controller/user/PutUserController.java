package fr.kolos.presentation.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.kolos.business.dto.UserDto;
import fr.kolos.business.service.user.IUserService;

/**
 * Controller class for handling requests to update users.
 */
@RestController
@CrossOrigin
public class PutUserController {

	private IUserService service;

	/**
	 * Update a user.
	 *
	 * @param userDto The DTO representing the user to be updated.
	 * @return The DTO representing the updated user.
	 */
	@PutMapping("/users")
	public UserDto putUser(@RequestBody final UserDto userDto) {
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
