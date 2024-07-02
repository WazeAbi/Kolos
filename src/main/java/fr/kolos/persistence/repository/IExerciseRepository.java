package fr.kolos.persistence.repository;

import fr.kolos.persistence.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExerciseRepository extends JpaRepository<Exercise , Integer> {
}
