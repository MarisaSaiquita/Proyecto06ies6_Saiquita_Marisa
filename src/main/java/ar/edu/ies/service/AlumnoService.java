package ar.edu.ies.service;


//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.ies.model.Alumno;
import ar.edu.ies.repository.AlumnoRepository;

@Service
public class AlumnoService {
	
	@Autowired
	AlumnoRepository alumnoRepository;
	
	public void guardarAlumno (Alumno alumno) {
		alumno.setEstado(true);
		alumnoRepository.save(alumno);
	}
 public void eliminarAlumno (Integer dni) {
	 
 }
 
 public List<Alumno> buscarTodosAlumnos(){
	 //List<Alumno> listado = new ArrayList<>();
	 //return listado;
	 
	 return (List<Alumno>) alumnoRepository.findAll();
	 
 }
 

}
// todosServicios 	


