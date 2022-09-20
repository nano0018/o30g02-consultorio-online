package co.edu.uis.interfaceService;

import java.util.Optional;
import java.util.List;

import co.edu.uis.models.Usuario;

public interface IuserService {
	public List<Usuario>listar();
	public Optional<Usuario>listarId(int id);
	public int save(Usuario u);
	public void delete(int id);
}
