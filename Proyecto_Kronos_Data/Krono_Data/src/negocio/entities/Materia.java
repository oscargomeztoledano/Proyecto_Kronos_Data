package negocio.entities;

import java.util.Date;

public class Materia {

	Profesor responsable;
	String dniProfesor;
	private String nombre;
	private double horas;
	private Date fechaInicio;
	private Date fechaFin;
	
	public Materia(Profesor responsable, String nombre, double horas, Date fechaInicio, Date fechaFin) {
		this.responsable = responsable;
		this.nombre = nombre;
		this.horas = horas;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	public Materia(String dniProfesor, String nombre, double horas, Date fechaInicio, Date fechaFin) {
		this.dniProfesor = dniProfesor;
		this.nombre = nombre;
		this.horas = horas;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	public Profesor getResponsable() {
		return responsable;
	}
	public void setResponsable(Profesor responsable) {
		this.responsable = responsable;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getHoras() {
		return horas;
	}
	public void setHoras(double horas) {
		this.horas = horas;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getDniProfesor() {
		return dniProfesor;
	}

	public void setDniProfesor(String dniProfesor) {
		this.dniProfesor = dniProfesor;
	}
	
	

}