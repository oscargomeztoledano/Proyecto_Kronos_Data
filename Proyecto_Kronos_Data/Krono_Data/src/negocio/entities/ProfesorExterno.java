package negocio.entities;

public class ProfesorExterno extends Profesor {

	public ProfesorExterno(String DNI, String contrasena, char tipo, String nombre, String apellidos, boolean doctor) {
		super(DNI, contrasena, tipo, nombre, apellidos, doctor);
		// TODO Auto-generated constructor stub
	}

	private String titulacion;

}