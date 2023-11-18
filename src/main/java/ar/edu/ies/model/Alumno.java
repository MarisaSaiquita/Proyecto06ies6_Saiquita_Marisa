package ar.edu.ies.model;


import java.time.LocalDate;

import java.time.Period;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
@Component
public class Alumno {
	@Column
	//@NotBlank @Size(min=1, max=30)
	private String name;
	@Column
	private String lastName;                   
	@Column
	private String addressStreet;
	@Column
	private Integer addressNumber;
	@Column
	private String localidad;
	@Column
	@DateTimeFormat (pattern="yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	@Column
	private String estadoCivil;
	@Column
	private String telefono;
	//identificador
	//@GenerateValue (strategy=GenerationType.AUTO)
	@Id
	private Integer dni;
	@Column
	private Boolean estado;
	
	//TODO agregarAtributos
	public Alumno() {
		// TODO Auto-generated constructor stub

	}
	
	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getLastName() {
		return lastName;
	}

	public void setLastname(String lastName) {
		this.lastName = lastName;
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

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
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

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Boolean getEstado() {
		return estado;
	}
	public Integer getEdad () {
		int edad=0;
	//TODO calculoEdad
		LocalDate fechaActual = LocalDate.now();
	Period periodo= Period.between (fechaNacimiento, fechaActual);
			edad=periodo.getYears();
	return edad;
		
	}
	

}
