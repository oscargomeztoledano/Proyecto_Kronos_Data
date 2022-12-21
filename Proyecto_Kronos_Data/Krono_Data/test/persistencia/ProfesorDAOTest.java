package persistencia;

import java.util.Vector;

import org.junit.Assert;
import org.junit.Test;

import negocio.entities.CategoriaProfesor;
import negocio.entities.Centro;
import negocio.entities.Profesor;
import negocio.entities.ProfesorExterno;
import negocio.entities.ProfesorUCLM;
import negocio.entities.Usuario;


public class ProfesorDAOTest {
@Test
	public void testseleccionarProfesor() throws Exception {
		Usuario usuario=new Usuario("12345678P","123","P");
		String sql = "SELECT * FROM dbo.Profesor WHERE Dni = '"+usuario.getDNI()+"'";

		Vector<Object> profesor = GestorBD.oneExecuteQuery(sql);
     
		
		if(profesor.size()==0) {
			Assert.assertEquals(0, profesor.size());
		}else {
			Profesor pro= new Profesor(usuario.getDNI(),usuario.getContrasena(),usuario.getTipo(), profesor.get(1).toString(),profesor.get(2).toString(),Boolean.parseBoolean(profesor.get(3).toString()));
			Assert.assertNotNull(pro);	
		}
	}

	@Test
	public void testseleccionarProfesorUCLM() throws Exception {
		Profesor profesor= new Profesor("12345678P", "123","P", "Ricardo", "Gomez", true);
		String sql = "SELECT * FROM profesoruclm WHERE Dni = '"+profesor.getDNI()+"'";

		Vector<Object> profesorUCLM = GestorBD.oneExecuteQuery(sql);
		if(profesorUCLM.size()==0) {
			Assert.assertEquals(0, profesorUCLM.size());
		}else {
			ProfesorUCLM pro= new ProfesorUCLM(profesor.getDNI(),profesor.getContrasena(),profesor.getTipo(),profesor.getNombre(),profesor.getApellidos(),profesor.isDoctor(), ProfesorDAO.comparacionCategoriaProfesor(profesorUCLM.get(1).toString()),CentroDAO.seleccionarCentro(profesorUCLM.get(2).toString()));
			Assert.assertNotNull(pro);	
		}

	}
@Test
	public void testseleccionarProfesorExterno() throws Exception {
		ProfesorUCLM profesor= new ProfesorUCLM("12345678P", "123","P", "Ricardo", "Gomez" , true,CategoriaProfesor.AYUDANTE,
				CentroDAO.seleccionarCentro("Talavera"));
		String sql = "SELECT * FROM profesorexterno WHERE dniprofesorExterno = '"+profesor.getDNI()+"'";

		Vector<Object> profesorExterno = GestorBD.oneExecuteQuery(sql);
		if(profesorExterno.size()==0) {
			Assert.assertEquals(0, profesorExterno.size());
		}else {
			ProfesorExterno proEx= new ProfesorExterno(profesor.getDNI(),profesor.getContrasena(),profesor.getTipo(),profesor.getNombre(),profesor.getApellidos(),profesor.isDoctor(),profesorExterno.get(1).toString());
			Assert.assertNotNull(proEx);	
		}
		

	}
	
}
