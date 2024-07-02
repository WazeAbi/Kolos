package fr.kolos.service;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.kolos.business.dto.MuscleDto;
import fr.kolos.business.service.muscle.MuscleServiceImpl;
import fr.kolos.persistence.entity.Muscle;
import fr.kolos.persistence.repository.IMuscleRepository;

@ExtendWith(MockitoExtension.class)
class MuscleServiceTest {

	@Mock
	private IMuscleRepository repo;

	@InjectMocks
	private MuscleServiceImpl service;

	private Muscle muscle = new Muscle();
	private MuscleDto muscleDto = new MuscleDto();

	@Test
	void getMuscles() {
		try {
			service.getMuscles();
			verify(repo, times(1)).findAll();
		} catch (Exception e) {
			fail(e);
		}
	}

	@Test
	void getMuscleById() {

		try {
			when(repo.getReferenceById(1)).thenReturn(muscle);
			service.getMuscleById(1);
			verify(repo, times(1)).getReferenceById(1);
		} catch (Exception e) {
			fail(e);
		}
	}

	@Test
	void PostMuscle() {
		try {
			when(repo.save(any(Muscle.class))).thenReturn(muscle);
			service.postMuscle(muscleDto);
			verify(repo, times(1)).save(any(Muscle.class));
		} catch (Exception e) {
			fail(e);
		}
	}

	@Test
	void deleteMuscle() {
		try {
			service.deleteMuscle(muscleDto);
			verify(repo, times(1)).delete(any(Muscle.class));
		} catch (Exception e) {
			fail(e);
		}
	}

}
