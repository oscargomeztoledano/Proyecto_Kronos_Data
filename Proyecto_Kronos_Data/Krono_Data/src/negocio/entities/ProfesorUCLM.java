package negocio.entities;

import java.util.Collection;

public class ProfesorUCLM extends Profesor {

	public ProfesorUCLM(String DNI, String contraseņa, char tipo, String nombre, String apellidos, boolean doctor) {
		super(DNI, contraseņa, tipo, nombre, apellidos, doctor);
		// TODO Auto-generated constructor stub
	}
	Centro centroAdscripcion;
	CategoriaProfesor categoria;
	private String nombre;
	private String apellidos;
	private String dni;
	
	

}