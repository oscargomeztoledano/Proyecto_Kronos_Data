package negocio.entities;

public class Usuario {
	String dni;
	String contrasena;
	String tipo;

	public Usuario(String dni, String contrasena, String tipo) {
		this.dni = dni;
		this.contrasena = contrasena;
		this.tipo = tipo;
	}
	
	public Usuario(String dni) {
		this.dni = dni;
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
		return "Usuario con Dni: "+ dni + " y con contrasena: "+ contrasena + " y es un usuario de tipo: "+ tipo;
	}

}
