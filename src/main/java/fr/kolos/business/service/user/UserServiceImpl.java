package fr.kolos.business.service.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.kolos.business.convert.UserConvert;
import fr.kolos.business.dto.UserDto;
import fr.kolos.persistence.entity.User;
import fr.kolos.persistence.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

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

	//TODO encode password
	@Override
	public UserDto postUser(UserDto userDto) {
		return UserConvert.getInstance()
				.convertEntityToDto(repo.save(UserConvert.getInstance().convertDtoToEntity(userDto)));
	}

	@Override
	public void deleteUser(UserDto userDto) {
		repo.delete(UserConvert.getInstance().convertDtoToEntity(userDto));
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) {
		User user = repo.loadUserByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with email: " + email);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				getAuthorities(user));
	}

	private Set<GrantedAuthority> getAuthorities(User user) {
		Set<GrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority(user.getRoleUser()));
		return authorities;
	}

	@Autowired
	public void setRepo(IUserRepository repo) {
		this.repo = repo;
	}

}
