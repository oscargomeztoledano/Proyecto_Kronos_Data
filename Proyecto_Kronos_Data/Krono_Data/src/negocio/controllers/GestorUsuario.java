package negocio.controllers;
import negocio.entities.*;
import persistencia.UsuarioDAO;
public class GestorUsuario {
	public boolean login(String DNI,String Contraseņa) {
		Usuario usuario = new Usuario(DNI,Contraseņa,(Character) null);
		int resultado= UsuarioDAO.getUsuario(usuario);
		return false;
	}

}
