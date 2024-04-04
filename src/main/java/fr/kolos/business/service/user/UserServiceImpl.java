package fr.kolos.business.service.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.kolos.business.convert.UserConvert;
import fr.kolos.business.dto.UserDto;
import fr.kolos.persistence.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	private IUserRepository repo;

	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);

	@Override
	public List<UserDto> getUsers() {
		return UserConvert.getInstance().convertListEntityToListDto(repo.findAll());
	}

	@Override
	public UserDto getUserById(int id) {
		return UserConvert.getInstance().convertEntityToDto(repo.getReferenceById(id));
	}

	@Override
	public UserDto postUser(UserDto userDto) {
		return UserConvert.getInstance()
				.convertEntityToDto(repo.save(UserConvert.getInstance().convertDtoToEntity(userDto)));
	}

	@Override
	public void deleteUser(UserDto userDto) {
		repo.delete(UserConvert.getInstance().convertDtoToEntity(userDto));
	}

	@Autowired
	public void setRepo(IUserRepository repo) {
		this.repo = repo;
	}

}
