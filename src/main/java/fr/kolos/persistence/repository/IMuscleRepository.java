package fr.kolos.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.kolos.persistence.entity.Muscle;



/**
 * This interface represents a repository for accessing User entities in the
 * system.
 */
@Repository
public interface IMuscleRepository extends JpaRepository<Muscle , Integer> {


}