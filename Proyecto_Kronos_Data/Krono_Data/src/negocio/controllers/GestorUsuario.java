package negocio.controllers;

import java.util.Vector;

import negocio.entities.*;
import persistencia.EstudianteDAO;
import persistencia.ProfesorDAO;
import persistencia.UsuarioDAO;

public class GestorUsuario {
	public char login(String DNI, String Contrasena) throws Exception {
		char login = '0';
		Usuario usuario;
		usuario = UsuarioDAO.seleccionarUsuario(DNI);
		if (usuario.getContrasena().equals(Contrasena)) {
			switch (usuario.getTipo()) {
			case "E":
				System.out.println("Estudiante");
				Estudiante estudiante = EstudianteDAO.seleccionarEstudiante(DNI);
				login = 'E';
				break;

			case "P":
				System.out.println("Profesor");
				Profesor profesor = ProfesorDAO.seleccionarProfesor(DNI);
				login = 'P';
				break;

			case "G":
				System.out.println("Jefe de Gabinete de Vicerrectorado");
				login = 'G';
				break;

			case "J":
				System.out.println("Personal de Vicerrectorado");
				login = 'J';
				break;
			default:
				login = '1';

				break;
			}
		}

		return login;
	}

}
