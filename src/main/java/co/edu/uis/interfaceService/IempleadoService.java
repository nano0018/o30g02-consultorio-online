package co.edu.uis.interfaceService;

import java.util.List;
import java.util.Optional;

import co.edu.uis.models.Empleado;

public interface IempleadoService {
	public List<Empleado>listar();
	public Optional<Empleado>listarId(int id);
	public int Save(Empleado e);
	public void delete(int id);
	

}
