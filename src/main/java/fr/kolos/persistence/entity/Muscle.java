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

    @Column(name = "name_muscle")
    private String nameMuscle;

    /**
     * Returns the unique identifier of the muscle.
     *
     * @return The unique identifier of the muscle.
     */

    public int getIdMuscle() {
        return idMuscle;
    }

    /**
     * Returns the unique identifier of the muscle.
     *
     * @return The unique identifier of the muscle.
     */
    public void setIdMuscle(int idMuscle) {
        this.idMuscle = idMuscle;
    }

    /**
     * Returns the name of the muscle.
     *
     * @return The name of the muscle.
     */
    public String getNameMuscle() {
        return nameMuscle;
    }

    /**
     * Returns the name of the muscle.
     *
     * @return The name of the muscle.
     */
    public void setNameMuscle(String nameMuscle) {
        this.nameMuscle = nameMuscle;
    }
}
