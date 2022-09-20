package co.edu.uis.interfaces;

import org.springframework.data.repository.CrudRepository;

import co.edu.uis.models.Empleado;

public interface IEmpleado extends CrudRepository<Empleado, Integer> {

}
