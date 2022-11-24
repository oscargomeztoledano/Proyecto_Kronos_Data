package negocio.controllers;


import negocio.entities.*;
import persistencia.EstudianteDAO;
import persistencia.ProfesorDAO;
import persistencia.UsuarioDAO;

public class GestorUsuario {

	Estudiante estudiante;
	ProfesorUCLM profesor;
	Usuario usuario;

	public char login(String dni, String contrasena) {

		char login = '1';
		Estudiante estudiante;
		ProfesorUCLM profesor;
		Usuario usuario;
		try {
			usuario = UsuarioDAO.seleccionarUsuario(dni);
			setUsuario(usuario);

			if (usuario.getContrasena().equals(contrasena)) {
				switch (usuario.getTipo()) {
				case "E":
					estudiante = EstudianteDAO.seleccionarEstudiante(dni);
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
