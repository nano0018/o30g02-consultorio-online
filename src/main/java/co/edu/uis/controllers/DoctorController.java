package co.edu.uis.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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

@Secured("ROLE_DOCTOR")
@Controller
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	DoctorServiceImpl doctorServiceImpl;
	
	@Autowired
	private CitaMedicaServiceImpl citaMedicaServiceImpl;
	
	@Autowired
	private UsuarioService usuarioServiceImpl;
	
	@GetMapping("")
	public String gestionHomeDoctor(Model model, Principal principal) {
		int idWorker = Integer.valueOf(principal.getName());
		int id = doctorServiceImpl.MedicoByIdWorker(idWorker);
		model.addAttribute("citamedica", citaMedicaServiceImpl.listarCitasMedicasbyDoctorId(id));
		System.out.println(id);
		return "doctor/GestionCitaMedicaDoctor";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Usuario>usuarios = usuarioServiceImpl.listar();
		model.addAttribute("usuarios", usuarios);
		return "doctor/GestionUsuariosDoctor";
	}
	
	@GetMapping("/new")
	public String agregarCita(Model model, Principal principal) {
		int idWorker = Integer.valueOf(principal.getName());
		int id = doctorServiceImpl.MedicoByIdWorker(idWorker);
		System.out.println(id);
		List<Usuario>  listaUsuario  = usuarioServiceImpl.listar();
		DoctorDto doctor = doctorServiceImpl.listarMedicosById(id).get();
		System.out.println(doctor.getIdDoctor());
		model.addAttribute("listaUsuario", listaUsuario);
		model.addAttribute("doctor", doctor);				
		model.addAttribute("citamedica", new CitaMedica());
		return "doctor/RegistrarCitaMedicaDoctor";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarCita(@PathVariable Integer id) {
		citaMedicaServiceImpl.deleteById(id);
		return "redirect:/doctor";
	}
	
	@PostMapping("/save")
	public String save(CitaMedica citaMedica) {
		System.out.println(citaMedica);
		citaMedicaServiceImpl.save(citaMedica);
		return "redirect:/doctor";
	}
	
	@GetMapping("/api/listar")
	@ResponseBody
	public List<DoctorDto> listarMedicos() {
		return doctorServiceImpl.listarMedicos();
	}
	
	@GetMapping("/api/{id}")
	@ResponseBody
	public List<CitaMedicDto> listarCitasMedicasbyDoctorId(@PathVariable Integer id) {		
		return citaMedicaServiceImpl.listarCitasMedicasbyDoctorId(id);
	}
	
	@GetMapping("/api/getIdWorker")
	@ResponseBody
	public Integer MedicoByIdWorker(Principal principal) {
		int id = Integer.valueOf(principal.getName());
		return doctorServiceImpl.MedicoByIdWorker(id);
	}
}
