package ar.edu.ies.util;

import java.util.List;
import ar.edu.ies.model.Docente;

import java.util.ArrayList;

public class ListadoDocentes {
private static List <Docente> listado= new ArrayList <>();
	public ListadoDocentes() {
		// TODO Auto-generated constructor stub
	}
	public static List<Docente> getListado() {
		return listado;
	}
	public static void setListado(List<Docente> listado) {
		ListadoDocentes.listado = listado;
	}
}

