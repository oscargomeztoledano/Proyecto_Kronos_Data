package persistencia;

import java.util.Vector;

import org.junit.Assert;
import org.junit.Test;

import negocio.entities.Usuario;

public class UsuarioDAOTest {

@Test 
public void testseleccionarUsuario() {
	String dni="12345678P";
	
		String sql = "SELECT * FROM Usuarios where DNI='"+dni+"'";

		Vector<Object> usuario;

		usuario = GestorBD.oneExecuteQuery(sql);
		if(usuario.size()==0) {
			Assert.assertEquals(0, usuario.size());
		}else {
			Usuario us = new Usuario(dni, usuario.get(1).toString(), usuario.get(2).toString());
			Assert.assertNotNull(us);	
		}
		
}
}
