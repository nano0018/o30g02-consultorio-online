package co.edu.uis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.edu.uis.models.CitaMedica;
import co.edu.uis.models.FormulaMedica;
import co.edu.uis.repository.CitaMedicaRepository;
import co.edu.uis.repository.FormulaMedicaRepository;

@Controller
@RequestMapping("/cita_medica")
public class CitaMedicaController {
	
	@Autowired
	private CitaMedicaRepository cmRepository;
	
	@Autowired
	private FormulaMedicaRepository fmRepository;
	
	@GetMapping("test_home")
	public String home(Model md) {
		md.addAttribute("medical_appointments", cmRepository.findAll());
		return "test_citas_medicas";
	}
	
	@GetMapping("listar")
	@ResponseBody
	public List<CitaMedica> listaCitaMedicas() {
		return cmRepository.findAll();
	}
	
	@GetMapping("formula")
	@ResponseBody
	public List<FormulaMedica> listaFormulaMedicas() {
		return fmRepository.findAll();
	}

}
