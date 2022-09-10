package co.edu.uis.o30g02consultorioonline.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uis.o30g02consultorioonline.models.CitaMedica;

@Repository
public interface CitaMedicaRepository extends JpaRepository<CitaMedica, Integer> {

}
