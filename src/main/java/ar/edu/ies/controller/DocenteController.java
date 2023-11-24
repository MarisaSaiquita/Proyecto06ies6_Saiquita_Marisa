package ar.edu.ies.controller;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ies.model.Docente;
import ar.edu.ies.service.DocenteService;

@Controller
public class DocenteController {
	@Autowired
	Docente docente;
	@Autowired
	DocenteService docenteService;

@GetMapping({"/principal", "/docente"})
public ModelAndView cargarDocente() {
    Docente docente = new Docente();
    docente.setFechaNacimiento(LocalDate.of(1986, 10, 12));
    System.out.println("Edad: " + docente.getEdad());

    ModelAndView modelView = new ModelAndView("principal");
    modelView.addObject("docente", docente);
    return modelView;
}

@PostMapping("/cargarDocente")
public ModelAndView guardarDocente(@ModelAttribute("docente") Docente docente) {
    docenteService.guardarDocente(docente);

    ModelAndView modelView = new ModelAndView("listadoDocentes");
    modelView.addObject("listado", docenteService.buscarTodosDocentes());
    return modelView;
}

@GetMapping("/eliminarDocente/{dni}")
public String eliminarDocente(@PathVariable Integer dni) throws Exception {
    docenteService.eliminarDocente(dni);
    return "redirect:/mostrarDocentes";
}

@GetMapping("/mostrarDocentes")
public ModelAndView mostrarDocente() {
    ModelAndView listado = new ModelAndView("listadoDocentes");
    listado.addObject("listado", docenteService.buscarTodosDocentes());
    return listado;
}

@GetMapping("/modificarDocente/{dni}")
public ModelAndView modificarDocente(@PathVariable Integer dni) throws Exception {
    ModelAndView modificaDocente = new ModelAndView("principal");
    modificaDocente.addObject("docente", docenteService.encontrarUnDocente(dni));
    return modificaDocente;
}

@PostMapping("/modificarDocente")
public ModelAndView modificarUnDocente(@ModelAttribute("docente") Docente docente) throws Exception {
    
	Docente docenteEncontrado = docenteService.encontrarUnDocente(docente.getDni());

    // Actualizar los datos del docente
    docenteEncontrado.setName(docente.getName());
    docenteEncontrado.setLastName(docente.getLastName());
    docenteEncontrado.setAddressStreet(docente.getAddressStreet());
    docenteEncontrado.setLocalidad(docente.getLocalidad());

    // Comprobar si el DNI se ha modificado
    if (docenteEncontrado.getDni() != docente.getDni()) {
        ModelAndView modelView = new ModelAndView("error");
        modelView.addObject("error", "El DNI no se puede modificar");
        return modelView;
    } else {
        // Guardar los cambios
        docenteService.guardarDocente(docenteEncontrado);

        ModelAndView modelView = new ModelAndView("listadoDocentes");
        modelView.addObject("listado", docenteService.buscarTodosDocentes());
        return modelView;
    }
}

@GetMapping("/listadoDocentes/volver")
public ModelAndView volver() {
    ModelAndView modelAndView = new ModelAndView("redirect:/principal");
    return modelAndView;
}

@GetMapping("/mostrarDocentes/volver")
public ModelAndView volverPortal() {
    ModelAndView modelAndView = new ModelAndView("redirect:/portal");
    return modelAndView;
}
}  

