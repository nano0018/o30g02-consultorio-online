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

import co.edu.uis.interfaceService.IempleadoService;
import co.edu.uis.models.Empleado;

@Controller
@RequestMapping("/managerEmpleados")
public class ContraladorEmpleado {

	@Autowired
	private IempleadoService service;
	
	@GetMapping("/listarEmpleados")
	public String listar(Model model) {
		List<Empleado>empleados=service.listar();
		model.addAttribute("empleados", empleados);
		return "GestionEmpleados";
	}
	
	@GetMapping("/newEmpleado")
	public String agregar(Model model) {
		model.addAttribute("empleado", new Empleado());
		return "GestionEmpleadosInputs";
	}
	
	@PostMapping("/saveEmpleado")
	public String save(@Valid Empleado e, Model model) {
		service.Save(e);
		return "redirect:/managerEmpleados/listarEmpleados";
	}
	
	@GetMapping("/editarEmpleado/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Empleado>empleado=service.listarId(id);
		model.addAttribute("empleado", empleado);
		return "GestionEmpleadosInputs";
	}
	
	@GetMapping("/eliminarEmpleado/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/managerEmpleados/listarEmpleados";
	}
}
