package ar.edu.ies.repository;

import org.springframework.stereotype.Repository;
import ar.edu.ies.model.Docente;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface DocenteRepository extends CrudRepository<Docente, Integer> {

	public List<Docente> findByEstado (Boolean estado);

	
}
