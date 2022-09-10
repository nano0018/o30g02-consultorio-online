package co.edu.uis.o30g02consultorioonline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.edu.uis.o30g02consultorioonline.models.CitaMedica;
import co.edu.uis.o30g02consultorioonline.models.FormulaMedica;
import co.edu.uis.o30g02consultorioonline.repository.CitaMedicaRepository;
import co.edu.uis.o30g02consultorioonline.repository.FormulaMedicaRepository;

@Controller
@RequestMapping("/cita_medica")
public class CitaMedicaController {
	
	@Autowired
	private CitaMedicaRepository cmRepository;
	
	@Autowired
	private FormulaMedicaRepository fmRepository;
	
	@GetMapping("home")
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
