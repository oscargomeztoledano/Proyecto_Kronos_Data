package negocio.controllers;

import negocio.entities.*;
import persistencia.UsuarioDAO;

public class GestorUsuario {
	public boolean login(String DNI, String Contrasena) {
		Usuario usuario = new Usuario(DNI, Contrasena, (Character) null);

		return false;
	}

}
