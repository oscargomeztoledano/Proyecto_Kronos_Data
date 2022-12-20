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

		String dni = "1234568G";
		String contrasena = "123";
		String Tipo = String.valueOf(dni.charAt(dni.length() - 1));

		Usuario u = UsuarioDAO.seleccionarUsuario(dni);
		Usuario u2= new Usuario(dni,contrasena,Tipo);
		char login = gestor.login(dni, contrasena);
		
		if ((!Tipo.equals("E")) && (!Tipo.equals("G")) && (!Tipo.equals("J"))
				 &&(!Tipo.equals("P"))) {
			Tipo = "1";

		}
		if(!(u.equals(null))) {
			Tipo="0";
		}
		System.out.println(login +" - " +Tipo);
		Assert.assertEquals(String.valueOf(login), Tipo);

	}
}
