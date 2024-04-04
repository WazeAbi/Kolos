package fr.kolos.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This class represents a Muscle entity in the system.
 */
@Entity
@Table(name = "muscle")
public class Muscle {

    /**
     * The unique identifier of the muscle.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_muscle")
    private int idMuscle;

    /**
     * Returns the unique identifier of the muscle.
     *
     * @return The unique identifier of the muscle.
     */

    public int getIdMuscle() {
        return idMuscle;
    }

    /**
     * Sets the unique identifier of the muscle.
     *
     * @param idMuscle The unique identifier of the muscle.
     */

    public void setIdMuscle(int idMuscle) {
        this.idMuscle = idMuscle;
    }

}
