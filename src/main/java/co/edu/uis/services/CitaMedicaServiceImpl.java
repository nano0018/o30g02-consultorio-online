package co.edu.uis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uis.dto.CitaMedicDto;
import co.edu.uis.interfaceService.ICitaMedicaService;
import co.edu.uis.models.CitaMedica;
import co.edu.uis.repository.CitaMedicaRepository;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService{
	
	@Autowired
	private CitaMedicaRepository cmRepository;

	@Override
	public List<CitaMedica> findAll() {
		// TODO Auto-generated method stub
		return cmRepository.findAll();
	}

	@Override
	public Optional<CitaMedica> findById(Integer id) {
		// TODO Auto-generated method stub
		return cmRepository.findById(id);
	}

	@Override
	public CitaMedica save(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		return cmRepository.save(citaMedica);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		cmRepository.deleteById(id);
		
	}

	@Override
	public List<CitaMedicDto> listarCitasMedicasbyUserId(Integer id) {
		// TODO Auto-generated method stub
		return cmRepository.listarCitasMedicasbyUserId(id);
	}

	@Override
	public List<CitaMedicDto> listaCitaMedicas() {
		// TODO Auto-generated method stub
		return cmRepository.listarCitasMedicas();
	}

	@Override
	public List<CitaMedicDto> listarCitasMedicasbyDoctorId(Integer id) {
		// TODO Auto-generated method stub
		return cmRepository.listarCitasMedicasbyDoctorId(id);
	}

}
