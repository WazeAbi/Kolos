package fr.kolos.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This class represents a User entity in the system.
 */
@Entity
@Table(name = "user")
public class User {

	/**
	 * The unique identifier of the user.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int idUser;

	/**
	 * The username of the user.
	 */
	@Column(name = "username", length = 100, nullable = false, unique = false)
	private String username;

	/**
	 * The email of the user.
	 */
	@Column(name = "email", length = 150, nullable = false, unique = true)
	private String email;

	/**
	 * The password of the user.
	 */
	@Column(name = "password", length = 255, nullable = false)
	private String password;

	/**
	 * The role of the user.
	 */
	@Column(name = "role", length = 20, nullable = false)
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
	public String getRoleUser() {
		return roleUSer;
	}

	/**
	 * Sets the role of the user.
	 *
	 * @param roleUSer The role of the user.
	 */
	public void setRoleUser(String roleUSer) {
		this.roleUSer = roleUSer;
	}
}
