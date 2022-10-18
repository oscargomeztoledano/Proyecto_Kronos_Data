package negocio.entities;

import java.util.*;

public class Estudiante extends Usuario{

	Collection<Matricula> matriculas;
	private String nombre;
	private String apellidos;
	private String titulacion;
	private String cualificacion;

public Estudiante(String DNI,String contrase�a,char tipo,Collection<Matricula> matriculas, String nombre,String apellidos,String titulacion,String cualificacion) {
	super(DNI,contrase�a,tipo);
	this.matriculas=matriculas;
	this.nombre=nombre;
	this.apellidos=apellidos;
	this.titulacion=titulacion;
	this.cualificacion=cualificacion;
}
}