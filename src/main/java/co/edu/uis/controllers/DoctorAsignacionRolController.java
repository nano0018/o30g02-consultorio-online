package co.edu.uis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.uis.dto.DoctorDto;
import co.edu.uis.interfaceService.IempleadoService;
import co.edu.uis.models.Doctor;
import co.edu.uis.models.Empleado;
import co.edu.uis.services.DoctorServiceImpl;

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping("/managerMedicos")
public class DoctorAsignacionRolController {
	
	@Autowired
	private DoctorServiceImpl doctorServiceImpl;
	
	@Autowired
	private IempleadoService service;
	
	@GetMapping("/listarMedicos")	
	public String listarMedicos(Model model) {
		List<DoctorDto> medicos = doctorServiceImpl.listarMedicos();
		model.addAttribute("medicos", medicos);
		return "GestionMedicos";
	}
	
	@GetMapping("/new")
	public String nuevoDoctor(Model model) {
		List<Empleado>empleados=service.listar();
		model.addAttribute("empleados", empleados);
		model.addAttribute("medico", new Doctor());
		return "RegistrarMedico";
	} 
	
	@PostMapping("/save")
	public String save(Doctor doctor) {
		doctor.setArea("General");
		System.out.println(doctor);
		doctorServiceImpl.save(doctor);
		return "redirect:/managerMedicos/listarMedicos";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarMedico(@PathVariable Integer id) {
		doctorServiceImpl.deleteById(id);
		return "redirect:/managerMedicos/listarMedicos";
	}
}
