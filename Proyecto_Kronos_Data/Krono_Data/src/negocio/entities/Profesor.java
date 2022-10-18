package negocio.entities;

import java.util.Collection;

public class Profesor extends Usuario{


	private String nombre;
	private String apellidos;
	private boolean doctor;
	
	public Profesor(String DNI,String contraseņa,char tipo, String nombre,String apellidos,boolean doctor) {
		super(DNI,contraseņa,tipo);
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.doctor=doctor;
	}

}