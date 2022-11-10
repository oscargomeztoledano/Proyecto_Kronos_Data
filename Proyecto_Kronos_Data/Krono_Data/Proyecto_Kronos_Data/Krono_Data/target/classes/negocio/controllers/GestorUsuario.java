package negocio.controllers;

import java.util.Vector;

import negocio.entities.*;
import persistencia.EstudianteDAO;
import persistencia.ProfesorDAO;
import persistencia.UsuarioDAO;
import presentacion.PantallaLogin;

public class GestorUsuario {

	Estudiante estudiante;
	Profesor profesor;
	Usuario usuario;

	public char login(String DNI, String Contrasena) {

		char login = '1';
		Estudiante estudiante;
		Profesor profesor;
		Usuario usuario;
		try {
			usuario = UsuarioDAO.seleccionarUsuario(DNI);
			setUsuario(usuario);

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
				}
			} else {
				login = '0';
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			login = '1';

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

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
