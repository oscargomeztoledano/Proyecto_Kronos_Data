package persistencia;

import java.sql.SQLException;
import java.util.Vector;

import negocio.entities.Estudiante;
import negocio.entities.Usuario;

public class UsuarioDAO<E> {

	public static Vector<Object> get(String SQL) throws Exception {
		Vector<Object> usuario = GestorBD.oneExecuteQuery(SQL);

		return usuario;
	}

	public static  Usuario seleccionarUsuario(String DNI) throws Exception {
		String SQL = "SELECT * FROM usuarios WHERE Dni = \'"+DNI+"\'";

		Vector<Object> usuario = get(SQL);
		Usuario us = new Usuario(DNI, usuario.get(1).toString(),usuario.get(2).toString());

		return us;
	}

}
