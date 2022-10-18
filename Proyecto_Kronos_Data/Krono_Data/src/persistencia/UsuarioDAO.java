package persistencia;

import java.sql.SQLException;

import negocio.entities.Usuario;

public class UsuarioDAO extends AbstractEntityDAO {
	

	public static int getUsuario(Usuario usuario) throws ClassNotFoundException {
		AbstractEntityDAO<Usuario> a;
		try {
			String selectUsuario = "select Dni, contrasena,TipoUsuario from usuarios where DNI=\'" + usuario.getDNI() + "\'";
			int resultado = GestorBD.select(selectUsuario);
			
			
			usuario.setDNI(a.get(0).toString());
			usuario.setNombre(a.get(1).toString());
			usuario.setEdad(a.get(2).toString());
		} catch (SQLException ex) {
			System.out.println("Error insertando socio de prueba" + ex);
		}
		
	return 0;
	}
}
