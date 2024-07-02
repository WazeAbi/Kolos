package fr.kolos.business.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import fr.kolos.business.dto.MuscleDto;
import fr.kolos.persistence.entity.Muscle;

/**
 * This class provides methods to convert between Muscle entities and DTOs.
 */
@Component
public class MuscleConvert {

    private static MuscleConvert instance;

    private MuscleConvert() {

    }

    /**
     * Retrieves the singleton instance of MuscleConvert.
     *
     * @return The singleton instance of MuscleConvert.
     */
    public static MuscleConvert getInstance() {
        if (instance == null) {
            instance = new MuscleConvert();
        }
        return instance;
    }

    /**
     * Converts a MuscleDto to a Muscle entity.
     *
     * @param dto The MuscleDto to be converted.
     * @return The corresponding Muscle entity.
     */
    public Muscle convertDtoToEntity(MuscleDto dto) {
        Muscle muscle = new Muscle();

        muscle.setIdMuscle(dto.getIdMuscle());
        muscle.setNameMuscle(dto.getNameMuscle());

        return muscle;
    }

    /**
     * Converts a list of MuscleDto objects to a list of Muscle entities.
     *
     * @param listDto The list of MuscleDto objects to be converted.
     * @return The corresponding list of Muscle entities.
     */
    public List<Muscle> convertListDtoToListEntity(List<MuscleDto> listDto) {
        List<Muscle> list = new ArrayList<>();
        for (MuscleDto muscle : listDto) {
            list.add(convertDtoToEntity(muscle));
        }
        return list;
    }

    /**
     * Converts a Muscle entity to a MuscleDto.
     *
     * @param muscle The Muscle entity to be converted.
     * @return The corresponding MuscleDto.
     */
    public MuscleDto convertEntityToDto(Muscle muscle) {
        MuscleDto dto = new MuscleDto();

        dto.setIdMuscle(dto.getIdMuscle());
        dto.setNameMuscle(dto.getNameMuscle());

        return dto;
    }

    /**
     * Converts a list of Muscle entities to a list of MuscleDto objects.
     *
     * @param list The list of Muscle entities to be converted.
     * @return The corresponding list of MuscleDto objects.
     */
    public List<MuscleDto> convertListEntityToListDto(List<Muscle> list) {
        List<MuscleDto> listDto = new ArrayList<>();
        for (Muscle muscle : list) {
            listDto.add(convertEntityToDto(muscle));
        }
        return listDto;
    }

}