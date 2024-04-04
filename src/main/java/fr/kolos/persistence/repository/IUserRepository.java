package fr.kolos.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.kolos.persistence.entity.User;

/**
 * This interface represents a repository for accessing User entities in the
 * system.
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.username = :username")
	public User loadUserByUsername(final String username);

}
