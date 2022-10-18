package negocio.controllers;
import negocio.entities.*;
import persistencia.UsuarioDAO;
public class GestorUsuario {
	public boolean login(String DNI,String Contraseña) {
		Usuario usuario = new Usuario(DNI,Contraseña,(Character) null);
		int resultado= UsuarioDAO.getUsuario(usuario);
		return false;
	}

}
