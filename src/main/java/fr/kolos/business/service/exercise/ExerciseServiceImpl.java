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
    private ExerciseConvert convertEx;

    @Override
    public List<ExerciseDto> ListExercises() {
        final List<Exercise> result = repoEx.findAll();
        return ExerciseConvert.getInstance().convertListEntityToListDto(result);
    }


    @Override
    public ExerciseDto getExerciseById(int id) {
        return convertEx.convertEntityToDto(repoEx.getReferenceById(id));
    }


    @Override
    public void deleteExercise(int id) {
        repoEx.deleteById(id);
    }

    @Override
    public void saveExercise(ExerciseDto exercise) {
        repoEx.save(convertEx.convertDtoToEntity(exercise));

    }

    @Autowired
    public void setRepoEx(IExerciseRepository repoEx) {
        this.repoEx = repoEx;
    }

    @Autowired

    public void setConvertEx(ExerciseConvert convertEx) {
        this.convertEx = convertEx;
    }
}
