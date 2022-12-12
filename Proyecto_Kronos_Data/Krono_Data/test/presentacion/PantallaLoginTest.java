package presentacion;

import static org.junit.Assert.assertEquals;

import negocio.entities.Usuario;
import persistencia.UsuarioDAO;

public class PantallaLoginTest {

	public void testlogin(String dni, String contrasena) {
		dni="12345678G";
		contrasena="123";
		Usuario u=UsuarioDAO.seleccionarUsuario(dni);
		char login='0';
	
		assertEquals(u.getContrasena(),contrasena);
		if(login>'0' && login < '9') {
			assertEquals(login,'0');
			assertEquals(login,'1');
		}else {
			assertEquals(login,'E');
			assertEquals(login,'G');
			assertEquals(login,'J');
			assertEquals(login,'P');
		
		
		}
		
		
		
	}
}
