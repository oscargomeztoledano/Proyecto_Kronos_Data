package negocio.entities;

import persistencia.AbstractEntityDAO;

public class Usuario {
	String DNI;
	String Contrase�a;
	char tipo;
	public Usuario(String DNI,String Contrase�a,char tipo) {
		this.DNI=DNI;
		this.Contrase�a=Contrase�a;
		this.tipo=tipo;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getContrase�a() {
		return Contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		Contrase�a = contrase�a;
	}
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	
}
