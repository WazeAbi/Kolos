package fr.kolos.business.service.exercise;

import fr.kolos.business.convert.ExerciseConvert;
import fr.kolos.business.dto.ExerciseDto;
import fr.kolos.persistence.entity.Exercise;
import fr.kolos.persistence.repository.IExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements IExerciseService {
    
	private IExerciseRepository repoEx;

    @Override
    public List<ExerciseDto> listExercises() {
        final List<Exercise> result = repoEx.findAll();
        return ExerciseConvert.getInstance().convertListEntityToListDto(result);
    }


    @Override
    public ExerciseDto getExerciseById(int id) {
        return ExerciseConvert.getInstance().convertEntityToDto(repoEx.getReferenceById(id));
    }


    @Override
    public void deleteExercise(ExerciseDto exerciseDto) {
        repoEx.delete(ExerciseConvert.getInstance().convertDtoToEntity(exerciseDto));
    }

    @Override
    public void saveExercise(ExerciseDto exerciseDto) {
        repoEx.save(ExerciseConvert.getInstance().convertDtoToEntity(exerciseDto));

    }

    @Autowired
    public void setRepoEx(IExerciseRepository repoEx) {
        this.repoEx = repoEx;
    }
}
