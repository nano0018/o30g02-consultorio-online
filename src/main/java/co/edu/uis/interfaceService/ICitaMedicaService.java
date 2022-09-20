package co.edu.uis.interfaceService;

import java.util.List;
import java.util.Optional;

import co.edu.uis.dto.CitaMedicDto;
import co.edu.uis.models.CitaMedica;

public interface ICitaMedicaService {
	
	public List<CitaMedica> findAll();
	public Optional<CitaMedica> findById(Integer id);
	public CitaMedica save(CitaMedica citaMedica);
	public void deleteById(Integer id);
	public List<CitaMedicDto> listarCitasMedicasbyUserId(Integer id);
	public List<CitaMedicDto> listarCitasMedicasbyDoctorId(Integer id);
	public List<CitaMedicDto> listaCitaMedicas();	

}
