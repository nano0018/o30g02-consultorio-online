package co.edu.uis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uis.models.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
