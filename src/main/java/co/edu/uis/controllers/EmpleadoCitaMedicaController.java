package co.edu.uis.controllers;

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
import co.edu.uis.repository.CitaMedicaRepository;
import co.edu.uis.services.CitaMedicaServiceImpl;
import co.edu.uis.services.DoctorServiceImpl;
import co.edu.uis.services.UsuarioService;

@Controller
@RequestMapping("/administacion_citas_medicas")
public class EmpleadoCitaMedicaController{
	
	@Autowired
	private CitaMedicaServiceImpl citaMedicaServiceImpl;
	
	@Autowired
	private UsuarioService usuarioServiceImpl;
	
	@Autowired
	DoctorServiceImpl doctorServiceImpl;
		
	@GetMapping("")
	public String gestionHome( Model model ) {
		model.addAttribute("citamedica", citaMedicaServiceImpl.listaCitaMedicas());
		return "citaMedica/GestionCitaMedica";
	}
	
	@GetMapping("/new")
	public String agregarCita(Model model) {		
		List<Usuario>  listaUsuario  = usuarioServiceImpl.listar();
		List<DoctorDto> listaMedicos = doctorServiceImpl.listarMedicos();
		model.addAttribute("listaUsuario", listaUsuario);
		model.addAttribute("listaMedicos", listaMedicos);
		for (DoctorDto dto : listaMedicos) {
			System.out.println(dto.getIdDoctor());
			System.out.println(dto.getEspecialidad());
			System.out.println(dto.getNombreMedico());
		}
		System.out.println("---");
		for (Usuario u : listaUsuario) {
			System.out.println(u.getUserId());
			System.out.println(u.getUserName());	
		}
		model.addAttribute("citamedica", new CitaMedica());
		return "citaMedica/RegistrarCitaMedica";
	}
	
	@PostMapping("/save")
	public String save(CitaMedica citaMedica) {
		System.out.println(citaMedica);
		citaMedicaServiceImpl.save(citaMedica);
		return "redirect:/administacion_citas_medicas";
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
