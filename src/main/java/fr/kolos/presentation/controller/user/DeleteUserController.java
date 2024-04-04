package fr.kolos.presentation.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.kolos.business.dto.UserDto;
import fr.kolos.business.service.user.IUserService;

/**
 * Controller class for handling requests to delete users.
 */
@RestController
@CrossOrigin
public class DeleteUserController {

	private IUserService service;

	/**
	 * Deletes a user using the provided user DTO.
	 *
	 * @param userDto The DTO representing the user to be deleted.
	 */
	@DeleteMapping("/users")
	public void deleteUser(@RequestBody final UserDto userDto) {
		service.deleteUser(userDto);
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
