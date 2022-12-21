package negocio.entities;

public class ProfesorUCLM extends Profesor {

	
	
		
	Centro centroAdscripcion;
	CategoriaProfesor categoria;
	String nombre;
	String apellidos;
	boolean doctor;
	
	public ProfesorUCLM(String dni, String contrasena, String tipo, String nombre, String apellidos, boolean doctor,CategoriaProfesor categoria,
			Centro centroAdscripcion) {
		super(dni, contrasena, tipo, nombre, apellidos, doctor);
		this.centroAdscripcion = centroAdscripcion;
		this.categoria = categoria;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.doctor = doctor;
	}


	
}