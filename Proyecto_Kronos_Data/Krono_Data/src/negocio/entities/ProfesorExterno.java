package negocio.entities;

public class ProfesorExterno extends Profesor {

	public ProfesorExterno(String DNI, String contraseņa, char tipo, String nombre, String apellidos, boolean doctor) {
		super(DNI, contraseņa, tipo, nombre, apellidos, doctor);
		// TODO Auto-generated constructor stub
	}

	private String titulacion;

}