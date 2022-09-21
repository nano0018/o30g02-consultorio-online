package co.edu.uis.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@PreAuthorize("!isAuthenticated()")
@Controller
@RequestMapping({"/", "/index", "/home"})
public class HomeController {
	
	@GetMapping("")
	public String index() {
		return "index2";
	}

}
