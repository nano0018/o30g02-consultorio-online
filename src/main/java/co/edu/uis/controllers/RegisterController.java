package co.edu.uis.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.uis.interfaceService.IuserService;
import co.edu.uis.models.Usuario;

@Controller
@RequestMapping("/reg")
public class RegisterController {
	
	@Autowired
	private IuserService service;
	
	@GetMapping("/register")
	public String agr(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "Register";
	}
	
	@PostMapping("/saveRegister")
	public String sv(@Valid Usuario u, Model model) {
		service.save(u);
		return "redirect:/login";
	}


}