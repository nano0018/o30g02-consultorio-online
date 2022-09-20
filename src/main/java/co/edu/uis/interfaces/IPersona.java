package co.edu.uis.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.uis.models.Usuario;


@Repository
public interface IPersona extends CrudRepository<Usuario, Integer>  {

}
