package persistencia;

import java.util.Vector;

import org.junit.Assert;
import org.junit.Test;

import negocio.entities.Centro;

public class CentroDAOTest {
@Test
public void testseleccionarCentro() {
	
	String nombre=" ";
		String sql = "SELECT * FROM dbo.Centro WHERE Nombre = '" + nombre + "'";

		Vector<Object> centro;

		centro = GestorBD.oneExecuteQuery(sql);
if(centro.size()==0) {
	Assert.assertEquals(0,centro.size());
}else {
	Centro ce = new Centro(nombre, centro.get(1).toString());
	Assert.assertNotNull(ce);
}
		

		
}
}
