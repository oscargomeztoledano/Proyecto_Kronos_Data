package negocio.entities;

public class Profesor extends Usuario{


	private String nombre;
	private String apellidos;
	private boolean doctor;
	private String dni;
	private String contrasena;
	private String tipo;
	
	public Profesor(String dni,String contrasena,String tipo, String nombre,String apellidos,boolean doctor) {
		super(dni,contrasena,tipo);
		this.dni=dni;
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
		return dni;
	}


	public void setDNI(String dni) {
		this.dni = dni;
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
		return "Profesor con: " + nombre + " " + apellidos + ", con DNI: " + dni ;
	}

}