package negocio.entities;

public class Usuario {
	String DNI;
	String Contrasena;
	String tipo;

	public Usuario(String DNI, String Contrasena, String tipo) {
		this.DNI = DNI;
		this.Contrasena = Contrasena;
		this.tipo = tipo;
	}
	
	public Usuario(String DNI) {
		this.DNI = DNI;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getContrasena() {
		return Contrasena;
	}

	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String toString() {
		return "Usuario con Dni: "+ DNI + " y con contrasena: "+ Contrasena + " y es un usuario de tipo: "+ tipo;
	}

}
