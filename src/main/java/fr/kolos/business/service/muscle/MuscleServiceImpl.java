package fr.kolos.business.service.muscle;

import java.util.List;
import java.util.Optional;

import fr.kolos.business.convert.MuscleConvert;
import fr.kolos.business.dto.MuscleDto;
import fr.kolos.persistence.entity.Muscle;
import fr.kolos.persistence.repository.IMuscleRepository;
import jakarta.persistence.EntityNotFoundException;

public class MuscleServiceImpl implements IMuscleService {

    private final IMuscleRepository iMuscleRepository;

    public MuscleServiceImpl(IMuscleRepository iMuscleRepository) {
        this.iMuscleRepository = iMuscleRepository;
    }

    @Override
    public List<MuscleDto> getMuscles() {
        List<Muscle> muscles = iMuscleRepository.findAll();
        return MuscleConvert.getInstance().convertListEntityToListDto(muscles);
    }

    @Override
    public MuscleDto getMuscleById(final int id) {
        Optional<Muscle> optionalMuscle = iMuscleRepository.findById(id);
        if (optionalMuscle.isPresent()) {
            Muscle muscle = optionalMuscle.get();
            return MuscleConvert.getInstance().convertEntityToDto(muscle);
        } else {
            throw new EntityNotFoundException("Muscle with id " + id + " not found.");
        }
    }

    @Override
    public MuscleDto PutMuscle(MuscleDto muscleDto, int id) {
        Optional<Muscle> optionalMuscle = iMuscleRepository.findById(id);
        if (optionalMuscle.isPresent()) {
            Muscle existingMuscle = optionalMuscle.get();
            existingMuscle.setIdMuscle(muscleDto.getIdMuscle());
            existingMuscle.setNameMuscle(muscleDto.getNameMuscle());
            Muscle updatedMuscle = iMuscleRepository.save(existingMuscle);
            return MuscleConvert.getInstance().convertEntityToDto(updatedMuscle);
        } else {
            throw new EntityNotFoundException("Muscle with id " + id + " not found.");
        }
    }

    @Override
    public void deletemuscle(int id) {
        Optional<Muscle> optionalMuscle = iMuscleRepository.findById(id);
        if (optionalMuscle.isPresent()) {
            iMuscleRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Muscle with id " + id + " not found.");
        }
    }

    @Override
    public MuscleDto PostMuscle(MuscleDto muscleDto) {
        Muscle muscleEntity = MuscleConvert.getInstance().convertDtoToEntity(muscleDto);
        Muscle savedMuscle = iMuscleRepository.save(muscleEntity);
        return MuscleConvert.getInstance().convertEntityToDto(savedMuscle);
    }

}
