package fr.kolos.business.service.muscle;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.kolos.business.dto.MuscleDto;

/**
 * Service interface for managing muscles.
 */
@Service
public interface IMuscleService {

    /**
     * Retrieves a list of all muscles.
     *
     * @return A list of MuscleDto objects representing all muscles.
     */
    List<MuscleDto> getMuscles();

    /**
     * Retrieves a muscle by its identifier.
     *
     * @param id The identifier of the muscle to retrieve.
     * @return The MuscleDto object representing the muscle with the specified ID.
     */
    MuscleDto getMuscleById(final int id);

    /**
     * Deletes a muscle with the specified identifier.
     *
     * @param id The identifier of the muscle to delete.
     */
    void deleteMuscle(final MuscleDto muscle);

    /**
     * Creates a new muscle with the provided data.
     *
     * @param muscle The MuscleDto object containing the data for the new muscle.
     * @return 
     */
    MuscleDto  postMuscle(MuscleDto muscle);
}
