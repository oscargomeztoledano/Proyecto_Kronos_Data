package negocio.controllers;
import negocio.entities.*;
import persistencia.UsuarioDAO;
public class GestorUsuario {
	public boolean login(String DNI,String Contrase�a) {
		Usuario usuario = new Usuario(DNI,Contrase�a,(Character) null);
		int resultado= UsuarioDAO.getUsuario(usuario);
		return false;
	}

}
