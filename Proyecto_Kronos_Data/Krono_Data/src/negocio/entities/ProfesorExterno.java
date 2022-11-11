package negocio.entities;

public class ProfesorExterno extends Profesor {

	public ProfesorExterno(String DNI, String contrasena, String tipo, String nombre, String apellidos, boolean doctor,String titulacion) {
		super(DNI, contrasena, tipo, nombre, apellidos, doctor);
		// TODO Auto-generated constructor stub
	}

	private String titulacion;

}