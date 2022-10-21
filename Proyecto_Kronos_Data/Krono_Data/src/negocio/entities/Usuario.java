package negocio.entities;

public class Usuario {
	String DNI;
	String Contrasena;
	char tipo;

	public Usuario(String DNI, String Contrasena, char tipo) {
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

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

}
