package negocio.controllers;

import java.util.Vector;

import negocio.entities.*;
import persistencia.EstudianteDAO;
import persistencia.ProfesorDAO;
import persistencia.UsuarioDAO;

public class GestorUsuario {

	Estudiante estudiante;
	Profesor profesor;
	public char login(String DNI, String Contraseña) throws Exception {

		char login = '0';
		Estudiante estudiante;
		Profesor profesor;
		Usuario usuario;
		usuario = UsuarioDAO.seleccionarUsuario(DNI);
		if (usuario.getContrasena().equals(Contrasena)) {
			switch (usuario.getTipo()) {
			case "E":
				 estudiante = EstudianteDAO.seleccionarEstudiante(DNI);
				 setEstudiante(estudiante);
				login = 'E';
				break;

			case "P":
				 profesor = ProfesorDAO.seleccionarProfesor(DNI);
				setProfesor(profesor);
				login = 'P';
				break;

			case "G":
				login = 'G';
				break;

			case "J":
				login = 'J';
				break;
			default:
				login = '1';

				break;
			}
		}

		return login;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public Profesor getProfesor() {
		return profesor;
	}

}
