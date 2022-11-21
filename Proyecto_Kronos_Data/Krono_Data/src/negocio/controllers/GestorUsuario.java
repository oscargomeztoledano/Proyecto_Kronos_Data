package negocio.controllers;

import java.util.Vector;

import negocio.entities.*;
import persistencia.EstudianteDAO;
import persistencia.ProfesorDAO;
import persistencia.UsuarioDAO;

public class GestorUsuario {

	Estudiante estudiante;
	ProfesorUCLM profesor;
	Usuario usuario;

	public char login(String DNI, String Contrasena) {

		char login = '1';
		Estudiante estudiante;
		ProfesorUCLM profesor;
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
					profesor = ProfesorDAO.seleccionarProfesorUCLM(ProfesorDAO.seleccionarProfesor(usuario));
					setProfesorUCLM(profesor);
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

	public void setProfesorUCLM(ProfesorUCLM profesor) {
		this.profesor = profesor;
	}

	public ProfesorUCLM getProfesorUCLM() {
		return profesor;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
