package fr.kolos.convert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import fr.kolos.business.convert.UserConvert;
import fr.kolos.business.dto.UserDto;
import fr.kolos.persistence.entity.User;

class UserConvertTest {

	private int idUser = 1;

	private String username = "Username";

	private String email = "email@email.com";

	private String password = "password";

	private String role = "USER";

	@Test
	void convertEntityToDto() {
		User user = new User();
		user.setIdUser(idUser);
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		user.setRoleUser(role);

		UserDto dto = UserConvert.getInstance().convertEntityToDto(user);

		assertEquals(user.getIdUser(), dto.getIdUser());
		assertEquals(user.getUsername(), dto.getUsername());
		assertEquals(user.getEmail(), dto.getEmail());
		assertEquals(user.getPassword(), dto.getPassword());
		assertEquals(user.getRoleUser(), dto.getRoleUser());
	}

	@Test
	void convertEntityToDtoException() {
		assertThrows(IllegalArgumentException.class, () -> UserConvert.getInstance().convertEntityToDto(null));
	}

	@Test
	void convertListEntityToListDto() {
		List<User> listUser = new ArrayList<>();
		User user1 = new User();
		User user2 = new User();
		user1.setIdUser(1);
		user2.setIdUser(2);
		listUser.add(user1);
		listUser.add(user2);

		List<UserDto> listDto = UserConvert.getInstance().convertListEntityToListDto(listUser);
		assertEquals(listDto.size(), listUser.size());
	}

	@Test
	void convertDtoToEntity() {
		UserDto dto = new UserDto();
		dto.setIdUser(idUser);
		dto.setUsername(username);
		dto.setEmail(email);
		dto.setPassword(password);
		dto.setRoleUser(role);

		User user = UserConvert.getInstance().convertDtoToEntity(dto);

		assertEquals(dto.getIdUser(), user.getIdUser());
		assertEquals(dto.getUsername(), user.getUsername());
		assertEquals(dto.getEmail(), user.getEmail());
		assertEquals(dto.getPassword(), user.getPassword());
		assertEquals(dto.getRoleUser(), user.getRoleUser());
	}

	@Test
	void convertDtoToEntityException() {
		assertThrows(IllegalArgumentException.class, () -> UserConvert.getInstance().convertDtoToEntity(null));
	}

	@Test
	void convertListDtoToListEntity() {
		List<UserDto> listDto = new ArrayList<>();
		UserDto user1 = new UserDto();
		UserDto user2 = new UserDto();
		user1.setIdUser(1);
		user2.setIdUser(2);
		listDto.add(user1);
		listDto.add(user2);

		List<User> listUser = UserConvert.getInstance().convertListDtoToListEntity(listDto);
		assertEquals(listUser.size(), listDto.size());
	}

}
