package co.edu.uis.interfaceService;

import java.util.List;
import java.util.Optional;

import co.edu.uis.dto.DoctorDto;
import co.edu.uis.models.Doctor;

public interface IDoctorService {
	
	public List<DoctorDto> listarMedicos();
	public List<Doctor> findAll();
	public Optional<Doctor> findById(Integer id);
	public Doctor save(Doctor doctor);
	public void deleteById(Integer id);
	public Optional<DoctorDto> listarMedicosById(Integer id);
}
