package fr.kolos.business.service.muscle;

import org.springframework.stereotype.Service;

import fr.kolos.business.convert.MuscleConvert;
import fr.kolos.business.dto.MuscleDto;
import fr.kolos.persistence.entity.Muscle;
import fr.kolos.persistence.repository.IMuscleRepository;

import java.util.List;

@Service
public class MuscleServiceImpl implements IMuscleService {
	
    private IMuscleRepository repoEx;

    @Override
    public List<MuscleDto> getMuscles() {
        final List<Muscle> result = repoEx.findAll();
        return MuscleConvert.getInstance().convertListEntityToListDto(result);
    }

    @Override
    public MuscleDto getMuscleById(final int id) {
        return MuscleConvert.getInstance().convertEntityToDto(repoEx.getReferenceById(id));
    }

    @Override
    public void deleteMuscle(final MuscleDto muscle) {
    	repoEx.delete(MuscleConvert.getInstance().convertDtoToEntity(muscle));
    }

    @Override
    public MuscleDto postMuscle(MuscleDto muscle) {
        return MuscleConvert.getInstance()
                .convertEntityToDto(repoEx.save(MuscleConvert.getInstance().convertDtoToEntity(muscle)));

    }

}