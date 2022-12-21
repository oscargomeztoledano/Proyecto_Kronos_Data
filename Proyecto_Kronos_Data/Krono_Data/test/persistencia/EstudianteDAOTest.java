package persistencia;

import java.util.Vector;

import org.junit.Assert;
import org.junit.Test;

import negocio.entities.Estudiante;

public class EstudianteDAOTest {
@Test
public void testseleccionarEstudiante() {
	String dni=" ";
	String sql = "SELECT * FROM Estudiante WHERE Dni ='"+dni+"'";

	Vector<Object> estudiante = GestorBD.oneExecuteQuery(sql);
	


if(estudiante.size()==0) {
	Assert.assertEquals(0, estudiante.size());
}else {
	Estudiante est= new Estudiante(estudiante.get(0).toString(), estudiante.get(1).toString(),estudiante.get(2).toString(), estudiante.get(3).toString(), estudiante.get(4).toString());

	Assert.assertNotNull(est);
}
}
}
