package co.edu.uis.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.uis.interfaceService.IuserService;

import co.edu.uis.models.Usuario;


@Controller
@RequestMapping("/managerUsuarios")
public class controlador {
	
	@Autowired
	private IuserService service;
	
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Usuario>usuarios = service.listar();
		model.addAttribute("usuarios", usuarios);
		return "GestionUsuarios";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "GestionUsuariosInputs";
	}
	
//	@GetMapping("/register")
//	public String agr(Model model) {
//		model.addAttribute("usuario", new Usuario());
//		return "Register";
//	}
//	
//	@PostMapping("/saveRegister")
//	public String sv(@Valid Usuario u, Model model) {
//		service.save(u);
//		return "redirect:/login";
//	}
	
	@PostMapping("/save")
	public String save(@Valid Usuario u, Model model) {
		service.save(u);
		return "redirect:/managerUsuarios/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Usuario>usuario=service.listarId(id);
		model.addAttribute("usuario", usuario);
		return "GestionUsuariosInputs";
	}
	
	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/managerUsuarios/listar";
	}
}
