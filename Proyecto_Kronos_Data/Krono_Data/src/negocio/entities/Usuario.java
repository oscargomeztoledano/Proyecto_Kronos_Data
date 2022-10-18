package negocio.entities;

import persistencia.AbstractEntityDAO;

public class Usuario {
	String DNI;
	String Contraseña;
	char tipo;
	public Usuario(String DNI,String Contraseña,char tipo) {
		this.DNI=DNI;
		this.Contraseña=Contraseña;
		this.tipo=tipo;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getContraseña() {
		return Contraseña;
	}
	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	
}
