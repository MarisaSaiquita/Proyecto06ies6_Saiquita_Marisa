package ar.edu.ies.service;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.ies.model.Docente;
import ar.edu.ies.repository.DocenteRepository;

@Service
public class DocenteService {
	
	@Autowired
	DocenteRepository docenteRepository;
	
	public void guardarDocente (Docente docente) {
		docente.setEstado(true);
		docenteRepository.save(docente);
	}
public void eliminarDocente (Integer dni) throws Exception{
	 
	 Docente auxiliar=new Docente();
	 auxiliar=encontrarUnDocente(dni);
	 auxiliar.setEstado(false);
	 docenteRepository.save(auxiliar);
	 
}
public List<Docente> buscarTodosDocentes(){
	
	//List <Docente> listado=new ArrayList();
	//return listado
	
	return (List <Docente>)docenteRepository.findByEstado(true);
	 
}
public void modificarUnDocente (Docente docente) {
	 
}
   public Docente encontrarUnDocente (Integer dni) throws Exception {
	
	return docenteRepository.findById(dni).orElseThrow(()-> new Exception ("Docente no encontrado"));
	 
}
		
	}
	

//todosServicios 	

