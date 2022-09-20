package co.edu.uis.controllers;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.edu.uis.dto.CitaMedicDto;
import co.edu.uis.dto.DoctorDto;
import co.edu.uis.models.CitaMedica;
import co.edu.uis.models.Usuario;
import co.edu.uis.services.CitaMedicaServiceImpl;
import co.edu.uis.services.DoctorServiceImpl;
import co.edu.uis.services.UsuarioService;

@Controller
@RequestMapping("/cita_medica")
public class UsuarioCitaMedicaController{
	
	@Autowired
	private CitaMedicaServiceImpl citaMedicaServiceImpl;
	
	@Autowired
	private UsuarioService usuarioServiceImpl;
	
	@Autowired
	DoctorServiceImpl doctorServiceImpl;
	
	@GetMapping("")
	public String gestionHomeUsuario( Model model ) {
		int id = 9289936;
		model.addAttribute("citamedica", citaMedicaServiceImpl.listarCitasMedicasbyUserId(id));
		return "citaMedica/GestionCitaMedicaUsuario";
	}
	
	@GetMapping("/new")
	public String agregarCita(Model model) {
		int id = 9289936;
		Usuario usuarioBD  = usuarioServiceImpl.listarId(id).get();
		List<DoctorDto> listaMedicos = doctorServiceImpl.listarMedicos();
		final String nombreCompletoUsuarioBD= usuarioBD.getUserName() + " " + usuarioBD.getUserLastName();		
		System.out.println(nombreCompletoUsuarioBD);
		System.out.println(usuarioBD.getUserId());
		model.addAttribute("usuario", usuarioBD);
		model.addAttribute("listaMedicos", listaMedicos);
		for (DoctorDto dto : listaMedicos) {
			System.out.println(dto.getIdDoctor());
			System.out.println(dto.getEspecialidad());
			System.out.println(dto.getNombreMedico());
		}		
		model.addAttribute("citamedica", new CitaMedica());
		return "citaMedica/RegistrarCitaMedicaUsuario";
	}
	
	@PostMapping("/save")
	public String save(CitaMedica citaMedica) {
		System.out.println(citaMedica);
		citaMedicaServiceImpl.save(citaMedica);
		return "redirect:/cita_medica";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarCita(@PathVariable Integer id) {
		citaMedicaServiceImpl.deleteById(id);
		return "redirect:/cita_medica";
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
