package negocio.entities;

import java.util.Collection;

public class Profesor extends Usuario{


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public boolean isDoctor() {
		return doctor;
	}


	public void setDoctor(boolean doctor) {
		this.doctor = doctor;
	}


	private String nombre;
	private String apellidos;
	private boolean doctor;
	
	public Profesor(String DNI,String contrasena,String tipo, String nombre,String apellidos,boolean doctor) {
		super(DNI,contrasena,tipo);
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.doctor=doctor;
	}
	
	
	public String toString() {
		return "Profesor con Dni: "+ DNI + " y con nombre: "+ nombre + " y apellidos: "+ apellidos ;
	}

}