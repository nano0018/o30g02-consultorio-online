package co.edu.uis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.uis.dto.DoctorDto;
import co.edu.uis.models.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	
	@Query(nativeQuery = true)
	List<DoctorDto> listarMedicos();
	
	@Query(nativeQuery = true)
	Optional<DoctorDto> listarMedicosById(Integer id);
}
