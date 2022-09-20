package co.edu.uis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uis.interfaceService.IempleadoService;
import co.edu.uis.interfaces.IEmpleado;
import co.edu.uis.models.Empleado;


@Service
public class EmpleadoService implements IempleadoService {
	
	@Autowired
	private IEmpleado data;

	@Override
	public List<Empleado> listar() {
		return (List<Empleado>) data.findAll();
	}

	@Override
	public Optional<Empleado> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int Save(Empleado e) {
		int res=0;
		Empleado empleado=data.save(e);
		if (!empleado.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
	}

}
