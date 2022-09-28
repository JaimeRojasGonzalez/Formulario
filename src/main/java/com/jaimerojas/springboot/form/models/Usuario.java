package com.jaimerojas.springboot.form.models;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public class Usuario {

	@NotEmpty(message="debes ingresar un nombre")
	private String nombre;
	
	@NotEmpty(message="debes ingresar un apellido")
	private String apellido;
	
	@Email(message="debes ingresar utilizar @")
	@NotEmpty(message="debes ingresar un correo")
	private String email;
	
	@NotNull(message="debes ingresar una fecha")
	@Past(message="debes ingresar una fecha en pasado")
	private Date fechaNac;
	
	@NotNull(message="debes ingresar un numero")
	@Min(1)
	@Max(111)
	private Integer edad;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

}
