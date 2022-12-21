package persistencia;

import java.util.Vector;
import negocio.entities.Usuario;
import presentacion.PantallaErrores;
import presentacion.PantallaLogin;

public class UsuarioDAO<E> {



	public static Usuario seleccionarUsuario(String dni) {
		Usuario us = null;
			String sql = "SELECT * FROM Usuarios where DNI='"+dni+"'";

			Vector<Object> usuario;
	
			usuario = GestorBD.oneExecuteQuery(sql);
			if(usuario.size()!=0) {
				us=new Usuario(dni, usuario.get(1).toString(), usuario.get(2).toString());
			}
			 

			return us;
		
		
	}

}
