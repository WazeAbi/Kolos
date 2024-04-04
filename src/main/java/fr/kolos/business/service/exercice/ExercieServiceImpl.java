package fr.kolos.business.service.exercice;

import fr.kolos.business.convert.ExerciceConvert;
import fr.kolos.business.dto.ExerciceDto;
import fr.kolos.persistence.entity.Exercice;
import fr.kolos.persistence.repository.IExerciceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExercieServiceImpl implements IExerciceService {
    private IExerciceRepository repoEx;
    private ExerciceConvert convertEx;

    @Override
    public void modifyExercice(ExerciceDto exercice, int id) {
        Exercice exerciceToUpdate = convertEx.convertDtoToEntity(exercice);
        Exercice exerciceExisting = repoEx.findById(id).orElse(null);
        if (exerciceExisting != null) {
            exerciceExisting.setNameExercice(exerciceToUpdate.getNameExercice());
            exerciceExisting.setDescription(exerciceToUpdate.getDescription());
            exerciceExisting.setUrlImage(exerciceToUpdate.getUrlImage());
            repoEx.save(exerciceExisting);
        }
    }

    @Override
    public void deleteExercice(int id) {
        repoEx.deleteById(id);
    }

    @Override
    public void createExercice(ExerciceDto exercice) {
        repoEx.save(convertEx.convertDtoToEntity(exercice));

    }

    @Autowired
    public void setRepoEx(IExerciceRepository repoEx) {
        this.repoEx = repoEx;
    }

    @Autowired

    public void setConvertEx(ExerciceConvert convertEx) {
        this.convertEx = convertEx;
    }
}
