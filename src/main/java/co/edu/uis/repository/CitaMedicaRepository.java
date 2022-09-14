package co.edu.uis.repository;

import org.springframework.stereotype.Repository;

import co.edu.uis.models.CitaMedica;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CitaMedicaRepository extends JpaRepository<CitaMedica, Integer> {

}
