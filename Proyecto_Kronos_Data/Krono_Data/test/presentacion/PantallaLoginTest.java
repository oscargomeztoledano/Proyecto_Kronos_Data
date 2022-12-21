package presentacion;



import org.junit.Assert;
import org.junit.Test;

import negocio.controllers.GestorUsuario;
import negocio.entities.Usuario;
import persistencia.UsuarioDAO;

public class PantallaLoginTest {
	@Test
	public void testLogin() {
		GestorUsuario gestor = new GestorUsuario();

		String dni = "12345678G";
		String contrasena = "13";
		String Tipo = String.valueOf(dni.charAt(dni.length() - 1));

		Usuario u = UsuarioDAO.seleccionarUsuario(dni);
		
		char login = gestor.login(dni, contrasena);
		
		
		if(u==null) {
			u= new Usuario(" ", " ", " ");
			Tipo = "1";
		}
		
		if(!(u.getContrasena().equals(contrasena))) {
			Tipo="0";
		}
		if ((!Tipo.equals("E")) && (!Tipo.equals("G")) && (!Tipo.equals("J"))
				 &&(!Tipo.equals("P")) && (!Tipo.equals("0"))) {
			Tipo = "1";

		}
		
		Assert.assertEquals(String.valueOf(login), Tipo);

	}
}
