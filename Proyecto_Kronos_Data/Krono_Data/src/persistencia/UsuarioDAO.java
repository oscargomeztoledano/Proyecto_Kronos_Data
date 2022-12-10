package persistencia;

import java.util.Vector;
import negocio.entities.Usuario;
import presentacion.PantallaLogin;

public class UsuarioDAO<E> {

	public static Vector<Object> get(String sql) throws Exception {

		return GestorBD.oneExecuteQuery(sql);
	}

	public static Usuario seleccionarUsuario(String dni) {
		Usuario us = null;
		try {
			String sql = "SELECT * FROM titulospropiosuclm2022.usuarios where DNI='"+dni+"'";

			Vector<Object> usuario;
	
			usuario = get(sql);

			us = new Usuario(dni, usuario.get(1).toString(), usuario.get(2).toString());

			return us;
		} catch (Exception e) {

			PantallaLogin.textPane.setText("Ha ocurrido un problema al introducir el usuario");
		}
		return us;
	}

}
