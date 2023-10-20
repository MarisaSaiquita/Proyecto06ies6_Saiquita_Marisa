package ar.edu.ies.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ies.model.Alumno;

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
		
	ModelAndView modelView= new ModelAndView ("listadoAlumos");
	//modelView.addObject ("alumno", alumno);
	return modelView;
	
}
	
}