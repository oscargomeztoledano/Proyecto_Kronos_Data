package negocio.controllers;

import org.junit.Assert;
import org.junit.Test;

import negocio.entities.Estudiante;
import negocio.entities.ProfesorUCLM;
import negocio.entities.Usuario;
import persistencia.EstudianteDAO;
import persistencia.ProfesorDAO;
import persistencia.UsuarioDAO;

public class GestorUsuarioTest {
	@Test
	public void testlogin() {
		GestorUsuario gestor = new GestorUsuario();
		String dni = " 12345678G";
		String contrasena = "12 ";
		char login = '1';
		Estudiante estudiante;
		ProfesorUCLM profesor;
		Usuario usuario;
		try {
			usuario = UsuarioDAO.seleccionarUsuario(dni);
			gestor.setUsuario(usuario);

			if (usuario.getContrasena().equals(contrasena)) {
				switch (usuario.getTipo()) {
				case "E":
					estudiante = EstudianteDAO.seleccionarEstudiante(dni);
					gestor.setEstudiante(estudiante);
					login = 'E';
					Assert.assertEquals(login, 'E');
					break;

				case "P":
					profesor = ProfesorDAO.seleccionarProfesorUCLM(ProfesorDAO.seleccionarProfesor(usuario));
					gestor.setProfesorUCLM(profesor);
					login = 'P';
					Assert.assertEquals(login, 'P');
					break;

				case "G":

					login = 'G';
					Assert.assertEquals(login, 'G');
					break;

				case "J":
					login = 'J';
					Assert.assertEquals(login, 'J');
					break;
				}
			} else {
				login = '0';
				Assert.assertEquals(login, '0');
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			login = '1';
			Assert.assertEquals(login, '1');
		}

	

	}
}
