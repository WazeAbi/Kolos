package fr.kolos.controller;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.kolos.business.dto.UserDto;
import fr.kolos.business.service.user.IUserService;
import fr.kolos.presentation.controller.user.DeleteUserController;
import fr.kolos.presentation.controller.user.GetUserByIdController;
import fr.kolos.presentation.controller.user.GetUsersController;
import fr.kolos.presentation.controller.user.PostUserController;
import fr.kolos.presentation.controller.user.PutUserController;


@ExtendWith(MockitoExtension.class)
class UserControllerTest {

	@Mock
	private IUserService service;

	@InjectMocks
	private GetUsersController getUsersController;

	@InjectMocks
	private GetUserByIdController getUserByIdController;

	@InjectMocks
	private PostUserController postUserController;
	
	@InjectMocks
	private PutUserController putUserController;

	@InjectMocks
	private DeleteUserController deleteUserController;

	UserDto userDto = new UserDto();

	@Test
	void getUsersController() {
		try {
			getUsersController.getUsers();
			verify(service, times(1)).getUsers();
		} catch (Exception e) {
			fail(e);
		}
	}

	@Test
	void getUserByIdController() {
		try {
			getUserByIdController.getUserById(1);
			verify(service, times(1)).getUserById(1);
		} catch (Exception e) {
			fail(e);
		}
	}

	@Test
	void postUserController() {
		try {
			postUserController.postUser(userDto);
			verify(service, times(1)).postUser(userDto);
		} catch (Exception e) {
			fail(e);
		}
	}
	
	@Test
	void putUserController() {
		try {
			putUserController.putUser(userDto);
			verify(service, times(1)).postUser(userDto);
		} catch (Exception e) {
			fail(e);
		}
	}

	@Test
	void deleteUserController() {
		try {
			deleteUserController.deleteUser(userDto);
			verify(service, times(1)).deleteUser(userDto);
		} catch (Exception e) {
			fail(e);
		}
	}

}

