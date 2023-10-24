package ar.edu.ies.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ies.model.Alumno;
import ar.edu.ies.util.ListadoAlumnos;

@Controller
public class AlumnoController {
	@GetMapping ({"/index","/","/home", "/ alumno"})
	
	public ModelAndView cargarAlumno () {
		Alumno alum= new Alumno();
		alum.setFechaNacimiento(LocalDate.of(2000, 2, 18));
		System.out.println("Edad: " + alum.getEdad());
		ModelAndView modelView= new ModelAndView ("index");
		
		modelView.addObject("alumno",alum);
		return modelView;	
}
	@PostMapping ("/cargarAlumno")
	public ModelAndView cargarAlumno (@ModelAttribute("alumno") Alumno alumno) {
    // TODO guardar alumno en una list
		ListadoAlumnos.getListado().add(alumno);

		ModelAndView modelView= new ModelAndView ("listadoAlumnos");
	// TODO enviar el listado a la tabla
		modelView.addObject ("listado", ListadoAlumnos.getListado());
	return modelView;
	
	
}
	
}