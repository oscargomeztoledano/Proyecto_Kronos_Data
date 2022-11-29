package persistencia;

import java.util.Vector;
import negocio.entities.Usuario;
import presentacion.PantallaLogin;

public class UsuarioDAO<E> {

	public static Vector<Object> get(String SQL) throws Exception {
		Vector<Object> usuario = GestorBD.oneExecuteQuery(SQL);

		return usuario;
	}

	public static Usuario seleccionarUsuario(String DNI) {
		Usuario us = null;
		try {
			String SQL = "SELECT * FROM Usuarios WHERE Dni = \'" + DNI + "\'";

			Vector<Object> usuario;

			usuario = get(SQL);

			us = new Usuario(DNI, usuario.get(1).toString(), usuario.get(2).toString());

			return us;
		} catch (Exception e) {

			PantallaLogin.textPane.setText("Ha ocurrido un problema al introducir el usuario");
		}
		return us;
	}

}
