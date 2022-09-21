package co.edu.uis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uis.dto.DoctorDto;
import co.edu.uis.interfaceService.IDoctorService;
import co.edu.uis.models.Doctor;
import co.edu.uis.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements IDoctorService {
	
	@Autowired
	DoctorRepository doctorRepository;

	@Override
	public List<DoctorDto> listarMedicos() {
		// TODO Auto-generated method stub
		return doctorRepository.listarMedicos();
	}

	@Override
	public List<Doctor> findAll() {
		// TODO Auto-generated method stub
		return doctorRepository.findAll();
	}

	@Override
	public Optional<Doctor> findById(Integer id) {
		// TODO Auto-generated method stub
		return doctorRepository.findById(id);
	}

	@Override
	public Doctor save(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorRepository.save(doctor);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		doctorRepository.deleteById(id);
		
	}

	@Override
	public Optional<DoctorDto> listarMedicosById(Integer id) {
		// TODO Auto-generated method stub
		return doctorRepository.listarMedicosById(id);
	}

	@Override
	public Integer MedicoByIdWorker(Integer id) {
		// TODO Auto-generated method stub
		return doctorRepository.MedicoByIdWorker(id);
	}

}
