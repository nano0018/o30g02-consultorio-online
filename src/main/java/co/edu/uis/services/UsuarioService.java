package co.edu.uis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uis.interfaceService.IuserService;
import co.edu.uis.interfaces.IPersona;
import co.edu.uis.models.Usuario;

@Service
public class UsuarioService implements IuserService {
	
	@Autowired
	private IPersona data;
	
	@Override
	public List<Usuario> listar() {
		return (List<Usuario>) data.findAll();
	}

	@Override
	public Optional<Usuario> listarId(int id) {
		// TODO Auto-generated method stub
		return data.findById(id);
	}

	@Override
	public int save(Usuario u) {
		// TODO Auto-generated method stub
		int res=0;
		Usuario usuario=data.save(u);
		if (!usuario.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		data.deleteById(id);
		
	}

}
