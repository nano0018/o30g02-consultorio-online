package co.edu.uis.repository;

import org.springframework.stereotype.Repository;

import co.edu.uis.dto.CitaMedicDto;
import co.edu.uis.models.CitaMedica;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface CitaMedicaRepository extends JpaRepository<CitaMedica, Integer> {
	
	@Query(nativeQuery = true)
	public List<CitaMedicDto> listarCitasMedicas();
	
	@Query(nativeQuery = true)
	public List<CitaMedicDto> listarCitasMedicasbyId(Integer id);

}
