package ar.edu.ies.model;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Component;

@Component
public class Alumno {
	private String name;
	private String lastname;
	private String addressStreet;
	private Integer addressNumber;
	private String addressCity;
	private LocalDate fechaNacimiento;
	private String dni;
	private String estadoCivil;
	private String telefono;
	private Boolean estado;
	
	//TODO agregarAtributos
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public Integer getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(Integer addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	
	}

	public Boolean getEstado() {
		return estado;
	}
	public Integer getEdad () {
	//TODO calculoEdad
		int edad=0;
	//LocalDate fechaN= fechaNacimiento.toInstant ().atZone (ZoneId.systemDefault()).toLocalDate();
		LocalDate fechaActual = LocalDate.now();
	Period periodo= Period.between (fechaNacimiento, fechaActual);
			edad=periodo.getYears();
	return edad;

}
}