package co.edu.uis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.edu.uis.dto.CitaMedicDto;
import co.edu.uis.models.CitaMedica;
import co.edu.uis.repository.CitaMedicaRepository;
import co.edu.uis.services.CitaMedicaServiceImpl;

@Controller
@RequestMapping("/administacion_citas_medicas")
public class EmpleadoCitaMedicaController{
	
	@Autowired
	private CitaMedicaServiceImpl citaMedicaServiceImpl ;
		
	@GetMapping("")
	public String GestionHome( Model model ) {
		model.addAttribute("citamedica", citaMedicaServiceImpl.listaCitaMedicas());
		return "citaMedica/GestionCitaMedica";
	}
	
	@GetMapping("/new")
	public String agregarCita( Model model ) {
		model.addAttribute("citamedica", new CitaMedica());
		return "citaMedica/RegistrarCitaMedica";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarCita(@PathVariable Integer id) {
		citaMedicaServiceImpl.deleteById(id);
		return "redirect:/administacion_citas_medicas";
	}
	
	@GetMapping("/gestionar_citas_usuario/eliminar/{id}")
	public String eliminarCitaUsuario(@PathVariable Integer id) {
		citaMedicaServiceImpl.deleteById(id);
		return "redirect:/administacion_citas_medicas";
	}
	
	@GetMapping("api/listar")
	@ResponseBody
	public List<CitaMedicDto> listaCitaMedicas() {
		return citaMedicaServiceImpl.listaCitaMedicas();
	}
	
	@GetMapping("api/{id}")
	@ResponseBody
	public List<CitaMedicDto> listarCitasMedicasbyUserId(@PathVariable Integer id) {		
		return citaMedicaServiceImpl.listarCitasMedicasbyUserId(id);
	}
	
	@GetMapping("api/listaCitas")
	@ResponseBody
	public List<CitaMedica> listarBDCitaMedica( ) {
		return citaMedicaServiceImpl.findAll();
	}
	
}
