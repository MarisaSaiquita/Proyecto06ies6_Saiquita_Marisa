package ar.edu.ies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ies.model.Calculadora;

@Controller
public class CalculadoraController {
	@GetMapping ({"/index","/","/home"})
	public ModelAndView recibirNumero () {
		Calculadora calcu= new Calculadora();
		ModelAndView modelView= new ModelAndView ("index");
		
		modelView.addObject("calcu",calcu);
		return modelView;	
		
	}
	
	@PostMapping ("/calcular")
	public ModelAndView calcularOperacion (@ModelAttribute("calcu") Calculadora calcu) {
	System.out.println("numero Guardado!"+ calcu.getNumA());
	calcu.setNumA(calcu.getNumA()* calcu.getNumA());
	ModelAndView modelView= new ModelAndView ("mostrarCalculo");
	modelView.addObject ("calcu", calcu);
	return modelView;
	
}
}