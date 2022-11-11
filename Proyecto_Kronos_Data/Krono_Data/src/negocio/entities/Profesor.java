package negocio.entities;

import java.util.Collection;

public class Profesor extends Usuario{


	private String nombre;
	private String apellidos;
	private boolean doctor;
	private String DNI;
	private String contrasena;
	private String tipo;
	
	public Profesor(String DNI,String contrasena,String tipo, String nombre,String apellidos,boolean doctor) {
		super(DNI,contrasena,tipo);
		this.DNI=DNI;
		this.contrasena=contrasena;
		this.tipo=tipo;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.doctor=doctor;
	}
	
	
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


	public String getDNI() {
		return DNI;
	}


	public void setDNI(String dNI) {
		DNI = dNI;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String toString() {
		return "Profesor con Dni: "+ DNI + " y con nombre: "+ nombre + " y apellidos: "+ apellidos ;
	}

}