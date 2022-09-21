package co.edu.uis.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@PreAuthorize("isAuthenticated()")
@Controller
public class DashboardController {

	@GetMapping("/dashboard")
	public String dashboard( ) {
		return "dashboard";
	}
}
