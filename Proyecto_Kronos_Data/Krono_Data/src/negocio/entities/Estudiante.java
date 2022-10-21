package negocio.entities;

import java.util.*;

public class Estudiante extends Usuario {

	Collection<Matricula> matriculas;
	private String nombre;
	private String apellidos;
	private String titulacion;
	private String cualificacion;

	public Estudiante(String DNI, String contrasena, char tipo, Collection<Matricula> matriculas, String nombre,
			String apellidos, String titulacion, String cualificacion) {
		super(DNI, contrasena, tipo);
		this.matriculas = matriculas;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.titulacion = titulacion;
		this.cualificacion = cualificacion;
	}
	
	public Estudiante(String DNI, String nombre, String apellidos, String titulacion, String cualificacion) {
		super(DNI);
		this.DNI = DNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.titulacion = titulacion;
		this.cualificacion = cualificacion;
		
	}

	public Collection<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(Collection<Matricula> matriculas) {
		this.matriculas = matriculas;
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

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	public String getCualificacion() {
		return cualificacion;
	}

	public void setCualificacion(String cualificacion) {
		this.cualificacion = cualificacion;
	}

}