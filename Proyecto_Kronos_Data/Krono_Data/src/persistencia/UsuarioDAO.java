package persistencia;

import java.sql.SQLException;
import java.util.Vector;

import negocio.entities.Estudiante;
import negocio.entities.Usuario;
import presentacion.PantallaLogin;

public class UsuarioDAO<E> {

	public static Vector<Object> get(String SQL) throws Exception {
		Vector<Object> usuario = GestorBD.oneExecuteQuery(SQL);

		return usuario;
	}

	public static  Usuario seleccionarUsuario(String DNI)  {
		Usuario us=null;
		try {
		String SQL = "SELECT * FROM Usuarios WHERE Dni = \'"+DNI+"\'";

		Vector<Object> usuario;
		
			usuario = get(SQL);
		
		 us = new Usuario(DNI, usuario.get(1).toString(),usuario.get(2).toString());
		
		return us;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			

			e.printStackTrace();
		}
		return us;
	}

}
