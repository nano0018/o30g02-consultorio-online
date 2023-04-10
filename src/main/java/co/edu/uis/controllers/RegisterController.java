package co.edu.uis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.uis.interfaceService.IuserService;
import co.edu.uis.models.Usuario;

@PreAuthorize("!isAuthenticated()")
@Controller
@RequestMapping("/reg")
public class RegisterController {
	
	@Autowired
	private IuserService service;
	
	@GetMapping("/register")
	public String agr(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "register";
	}
	
	@PostMapping("/saveRegister")
	public String sv( Usuario u, Model model) {
		service.save(u);
		return "redirect:/login";
	}


}