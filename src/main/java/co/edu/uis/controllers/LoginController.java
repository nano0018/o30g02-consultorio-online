package co.edu.uis.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@PreAuthorize("!isAuthenticated()")
@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}