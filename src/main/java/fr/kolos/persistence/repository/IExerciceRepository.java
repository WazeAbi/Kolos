package fr.kolos.persistence.repository;

import fr.kolos.persistence.entity.Exercice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExerciceRepository extends JpaRepository<Exercice , Integer> {
}
