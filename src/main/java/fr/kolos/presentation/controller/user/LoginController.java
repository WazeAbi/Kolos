package fr.kolos.presentation.controller.user;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.kolos.configuration.JWTService;


@RestController
public class LoginController {

	JWTService jwtService;

	public LoginController(JWTService jwtService) {
		this.jwtService = jwtService;
	}

	@PostMapping("/login")
	public String getToken(Authentication authentication) {
		return jwtService.generateToken(authentication);
	}

}
