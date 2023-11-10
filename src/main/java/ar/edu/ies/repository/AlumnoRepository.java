package ar.edu.ies.repository;

import org.springframework.stereotype.Repository;
import ar.edu.ies.model.Alumno;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Integer> {

	
	 

}
