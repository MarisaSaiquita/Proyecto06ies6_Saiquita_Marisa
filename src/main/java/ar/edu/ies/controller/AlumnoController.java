package ar.edu.ies.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ies.model.Alumno;
import ar.edu.ies.service.AlumnoService;

@Controller
public class AlumnoController {
	
	@Autowired
	Alumno alum;
	
	@Autowired
	AlumnoService alumnoService;
	
	@GetMapping ({"/index","/","/home"})	
	public ModelAndView Principal () {
		
		ModelAndView modelView= new ModelAndView ("portal");
		return modelView;	
		}
	
	@GetMapping ({"/alumno"})	
	public ModelAndView cargarAlumno () {
		//Alumno alum= new Alumno();
		alum.setFechaNacimiento(LocalDate.of (1986,03,23));
		System.out.println("Edad: " + alum.getEdad());
		
		ModelAndView modelView= new ModelAndView ("index");
		modelView.addObject("alumno",alum);
		
		return modelView;	
		}
	@PostMapping ("/cargarAlumno")
	public ModelAndView cargarAlumno (@ModelAttribute("alumno") Alumno alumno) {
    // TODO guardar alumno en una list
		//ListadoAlumnos.getListado().add(alumno);
		//guardarBD
		
		alumnoService.guardarAlumno(alumno);
		
		ModelAndView modelView= new ModelAndView ("listadoAlumnos");
	// TODO enviarListado
		//modelView.addObject ("listado", ListadoAlumnos.getListado());
		
		//buscarBD
		modelView.addObject ("listado", alumnoService.buscarTodosAlumnos());
		return modelView;	
}
	@GetMapping("/eliminarAlumno/{dni}")
	public String eliminarAlumno(@PathVariable Integer dni) throws Exception {
		
		alumnoService.eliminarAlumno(dni);
		
		return "redirect:/mostrarListado";		
}	 
	@GetMapping ("/mostrarListado")
	public ModelAndView mostrarAlumno() {
		
		ModelAndView listado=new ModelAndView("listadoAlumnos");
		//listado.addObject("listado", ListadoAlumnos.getListado() );
		listado.addObject("listado", alumnoService.buscarTodosAlumnos() );
		
		return listado;
	}
	
	@GetMapping("/modificarAlumno/{dni}")
	public ModelAndView modificarAlumno(@PathVariable Integer dni) throws Exception{
	
	ModelAndView modificaAlumno= new ModelAndView ("index");
	 modificaAlumno.addObject("alumno", alumnoService.encontrarUnAlumno(dni));
	 
	 return modificaAlumno;
	
	}

	//@PostMapping ("/modificarAlumno")
	//public ModelAndView modificarUnAlumno (@ModelAttribute("alumno") Alumno alumno) {
	//alumnoService.guardarAlumno(alumno);
		
		//ModelAndView modelView= new ModelAndView ("listadoAlumnos");
		//modelView.addObject ("listado", alumnoService.buscarTodosAlumnos());
		//return modelView;

	@GetMapping("/listadoAlumnos/volver")
	  public ModelAndView volver() {
	    // Crear el ModelAndView
	    ModelAndView modelAndView = new ModelAndView("redirect:/index");

	    return modelAndView;
	  }
	@PostMapping("/modificarAlumno")
	public ModelAndView modificarUnAlumno(@ModelAttribute("alumno") Alumno alumno) throws Exception {
	    // Recuperar los datos originales del alumno
	    Alumno modificaAlumno = alumnoService.encontrarUnAlumno(alumno.getDni());
	    
	    // Validar que el DNI no se haya modificado
	    if (modificaAlumno.getDni() != alumno.getDni()) {
	        // Mostrar un mensaje de error
	        ModelAndView modelView = new ModelAndView("error");
	        modelView.addObject("mensaje", "No se puede modificar el DNI");
	        return modelView;
	    }
	    
	    // Actualizar todos los campos editables excepto el DNI
	    modificaAlumno.setName(alumno.getName());
	    modificaAlumno.setLastName(alumno.getLastName());
	    modificaAlumno.setAddressStreet(alumno.getAddressStreet());
	    modificaAlumno.setAddressNumber(alumno.getAddressNumber());
	    modificaAlumno.setLocalidad(alumno.getLocalidad());
	    modificaAlumno.setFechaNacimiento(alumno.getFechaNacimiento());
	    modificaAlumno.setEstadoCivil(alumno.getEstadoCivil());
	    modificaAlumno.setTelefono(alumno.getTelefono());
	 // Guardar los datos actualizados del alumno
	    alumnoService.guardarAlumno(modificaAlumno);
	    
	 // Redirigir a la página de la lista de alumnos
	    ModelAndView modelView = new ModelAndView("listadoAlumnos");
	    modelView.addObject("listado", alumnoService.buscarTodosAlumnos());
	    return modelView;
	    
	    
	    	
	    }
	    
	 }
