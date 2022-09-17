package co.edu.uis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.edu.uis.dto.CitaMedicDto;
import co.edu.uis.repository.CitaMedicaRepository;
import co.edu.uis.services.CitaMedicaServiceImpl;

@Controller
@RequestMapping("/cita_medica")
public class CitaMedicaController{
	
	@Autowired
	private CitaMedicaServiceImpl citaMedicaServiceImpl ;
		
	
	@GetMapping("/listar")
	@ResponseBody
	public List<CitaMedicDto> listaCitaMedicas() {
		return citaMedicaServiceImpl.listaCitaMedicas();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public List<CitaMedicDto> listaCitaMedicasById(@PathVariable Integer id) {		
		return citaMedicaServiceImpl.listaCitaMedicasById(id);
	}
	
}
