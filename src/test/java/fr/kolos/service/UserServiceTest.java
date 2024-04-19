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

import fr.kolos.business.dto.UserDto;
import fr.kolos.business.service.user.UserServiceImpl;
import fr.kolos.persistence.entity.User;
import fr.kolos.persistence.repository.IUserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@Mock
	private IUserRepository repo;

	@InjectMocks
	private UserServiceImpl service;

	private User user = new User();
	private UserDto userDto = new UserDto();

	@Test
	void getUsers() {
		try {
			service.getUsers();
			verify(repo, times(1)).findAll();
		} catch (Exception e) {
			fail(e);
		}
	}

	@Test
	void getUserById() {
		try {
			when(repo.getReferenceById(1)).thenReturn(user);
			service.getUserById(1);
			verify(repo, times(1)).getReferenceById(1);
		} catch (Exception e) {
			fail(e);
		}
	}

	@Test
	void postUser() {
		try {
			UserDto dto = new UserDto();
			dto.setPassword("Password1!");
			when(repo.save(any(User.class))).thenReturn(user);
			service.postUser(dto);
			verify(repo, times(1)).save(any(User.class));
		} catch (Exception e) {
			fail(e);
		}
	}

	@Test
	void deleteUser() {
		try {
			service.deleteUser(userDto);
			verify(repo, times(1)).delete(any(User.class));
		} catch (Exception e) {
			fail(e);
		}
	}

}
