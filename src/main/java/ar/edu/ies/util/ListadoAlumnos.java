package ar.edu.ies.util;

import java.util.List;
import ar.edu.ies.model.Alumno;
import java.util.ArrayList;

public class ListadoAlumnos {
private static List <Alumno> listado= new ArrayList <>();
	public ListadoAlumnos() {
		// TODO Auto-generated constructor stub
	}
	public static List<Alumno> getListado() {
		return listado;
	}
	public static void setListado(List<Alumno> listado) {
		ListadoAlumnos.listado = listado;
	}
}
