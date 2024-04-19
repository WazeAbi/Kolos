package fr.kolos.business.service.user;

import java.util.List;

import fr.kolos.business.dto.UserDto;

/**
 * This interface defines the user-related services.
 */
public interface IUserService {

	/**
	 * Retrieves a list of all users.
	 *
	 * @return A list of all users.
	 */
	public List<UserDto> getUsers();

	/**
	 * Retrieves a user by their unique identifier.
	 *
	 * @param id The unique identifier of the user.
	 * @return The user DTO corresponding to the given identifier.
	 */
	public UserDto getUserById(final int id);

	/**
	 * Creates a new user.
	 *
	 * @param userDto The DTO representing the user to be created.
	 * @return The DTO representing the newly created user.
	 * @throws IllegalAccessException
	 */
	public UserDto postUser(final UserDto userDto) throws IllegalArgumentException;

	/**
	 * Deletes a user.
	 *
	 * @param userDto The DTO representing the user to be deleted.
	 */
	public void deleteUser(final UserDto userDto);

}
