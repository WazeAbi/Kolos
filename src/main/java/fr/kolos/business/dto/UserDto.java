package fr.kolos.business.dto;

/**
 * This class represents a DTO (Data Transfer Object) for User entities.
 */
public class UserDto {

	private int idUser;

	/**
	 * The username of the user.
	 */
	private String username;

	/**
	 * The email of the user.
	 */
	private String email;

	/**
	 * The password of the user.
	 */
	private String password;

	/**
	 * The role of the user.
	 */
	private String roleUSer;

	/**
	 * Returns the unique identifier of the user.
	 *
	 * @return The unique identifier of the user.
	 */
	public int getIdUser() {
		return idUser;
	}

	/**
	 * Sets the unique identifier of the user.
	 *
	 * @param idUser The unique identifier of the user.
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	/**
	 * Returns the username of the user.
	 *
	 * @return The username of the user.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username of the user.
	 *
	 * @param username The username of the user.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Returns the email of the user.
	 *
	 * @return The email of the user.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email of the user.
	 *
	 * @param email The email of the user.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Returns the password of the user.
	 *
	 * @return The password of the user.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the user.
	 *
	 * @param password The password of the user.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Returns the role of the user.
	 *
	 * @return The role of the user.
	 */
	public String getRoleUSer() {
		return roleUSer;
	}

	/**
	 * Sets the role of the user.
	 *
	 * @param roleUSer The role of the user.
	 */
	public void setRoleUSer(String roleUSer) {
		this.roleUSer = roleUSer;
	}

}
