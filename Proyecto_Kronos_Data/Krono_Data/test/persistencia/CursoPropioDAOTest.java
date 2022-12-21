package persistencia;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.junit.Assert;
import org.junit.Test;

import negocio.controllers.GestorUsuario;
import negocio.entities.CategoriaProfesor;
import negocio.entities.Centro;
import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import negocio.entities.ProfesorUCLM;
import negocio.entities.TipoCurso;
import negocio.entities.Usuario;
import presentacion.PantallaErrores;
public class CursoPropioDAOTest {
@Test
public void testcrearNuevoCurso() throws Exception {
	int resultado=0;
	GestorUsuario gestor=new GestorUsuario();
	Usuario usuario= new Usuario("12345678P","123","P");
	Usuario usuario2= new Usuario("23456789P","123","P");
	ProfesorUCLM director= ProfesorDAO.seleccionarProfesorUCLM(ProfesorDAO.seleccionarProfesor(usuario));
	ProfesorUCLM secretario= ProfesorDAO.seleccionarProfesorUCLM(ProfesorDAO.seleccionarProfesor(usuario2));;
	Centro centro=CentroDAO.seleccionarCentro("Informatica");
	List<CursoPropio> cursosAntes =CursoPropioDAO.obtenerCursos();

		
	
	
	
	Date fechaInicio=new Date(122,9,9);
	Date fechaFin=new Date(123,1,1);
	Date fechamat=new Date(122,9,1);
	CursoPropio curso = new CursoPropio("0", "Curso4", 16, fechaInicio, fechaFin,
			160, 1, TipoCurso.ESPECIALISTA, EstadoCurso.PROPUESTO,centro , director, secretario, new Date(),
			fechamat, " ");
		
	resultado= CursoPropioDAO.crearNuevoCurso(curso);
	
	List<CursoPropio> cursosDespues =CursoPropioDAO.obtenerCursos();
	if(resultado==0) {
		Assert.assertEquals(resultado, 0);
		Assert.assertTrue((cursosAntes.size())== cursosDespues.size());

	}else {
		Assert.assertEquals(resultado, 1);
	Assert.assertTrue((cursosAntes.size()+1)== cursosDespues.size());

	}


}
@Test
public void testeditarCurso() {
	int resultado = 0;
	ProfesorUCLM director= new ProfesorUCLM("12345678P","123","P", "Nombre", "Apellidos", true,CategoriaProfesor.AYUDANTE,
			new Centro("nombre","localizacion"));
	ProfesorUCLM secretario= new ProfesorUCLM("23456789P","123","P", "Nombre", "Apellidos", true,CategoriaProfesor.AYUDANTE,
			new Centro("nombre","localizacion"));
	Date fechaInicio=new Date(122,9,9);
	Date fechaFin=new Date(123,1,1);
	Date fechamat=new Date(122,9,1);
	CursoPropio curso = new CursoPropio("0", "Curso4", 16, fechaInicio, fechaFin,
			160, 1, TipoCurso.ESPECIALISTA, EstadoCurso.PROPUESTO, new Centro("Salud","Talavera"), director, secretario, new Date(),
			fechamat, " ");
	
	
		resultado = CursoPropioDAO.editarCurso(curso);
		
	
}
@Test
public void testlistarIngresos() throws Exception {
	String[] listaIngresos=CursoPropioDAO.listarIngresos();
	Assert.assertNotNull(listaIngresos);
}
@Test
public void testlistarEdicionesCursos() throws Exception {
	String edicion="1";
	String sql = "SELECT * FROM dbo.CursoPropio WHERE Edicion =" + edicion;
	Vector<Object> v=GestorBD.executeQuery(sql);

		List<CursoPropio> listaCursos = new ArrayList<>();
		listaCursos = CursoPropioDAO.recogerCursos(v, listaCursos);
		if(listaCursos.size()==0) {
			Assert.assertEquals(listaCursos.size(),0);
		}else {
			Assert.assertNotNull(listaCursos);
		}
	

}
	
@Test
public void testobtenerCursos() throws Exception {
	String sql = "SELECT * FROM CursoPropio ";

	Vector<Object> c = GestorBD.executeQuery(sql);
	List<CursoPropio> listaCursosPorObtener= new ArrayList<CursoPropio>();
	List<CursoPropio> listaObtenida = CursoPropioDAO.recogerCursos(c, listaCursosPorObtener);
	if(listaObtenida.size()==0) {
		Assert.assertEquals(listaObtenida.size(),0);
	}else {
		Assert.assertNotNull(listaObtenida);
	}
}
@Test
public void testrecogerCursos() throws Exception {
	String sql = "SELECT * FROM CursoPropio ";
	
	
	Vector<Object> c = GestorBD.executeQuery(sql);
	List<CursoPropio> listaCursos = new ArrayList<CursoPropio>();
	while (!c.isEmpty()) {
		Vector<Object> v = (Vector<Object>) c.get(0);
		ProfesorUCLM dir = ProfesorDAO.seleccionarProfesorUCLM(
				ProfesorDAO.seleccionarProfesor(UsuarioDAO.seleccionarUsuario(v.get(10).toString())));
		ProfesorUCLM sec = ProfesorDAO.seleccionarProfesorUCLM(
				ProfesorDAO.seleccionarProfesor(UsuarioDAO.seleccionarUsuario(v.get(11).toString())));
		CursoPropio curso = new CursoPropio(v.get(0).toString(), v.get(1).toString(), (Integer) v.get(2),
				(Date) v.get(3), (Date) v.get(4), (Double) v.get(5), (Integer) v.get(6),
				CursoPropioDAO.comparaciontipocurso(v.get(7).toString()), CursoPropioDAO.comparacionestadocurso(v.get(8).toString()),
				CentroDAO.seleccionarCentro(v.get(9).toString()), dir, sec, (Date) v.get(12), (Date) v.get(13),
				v.get(14).toString());

		listaCursos.add(curso);
		c.remove(0);

	}
	if(listaCursos.size()==0) {
		Assert.assertNull(listaCursos);
	}else {
		Assert.assertNotNull(listaCursos);
	}

}
@Test
public void testobtenerCursosporEstado() throws Exception {
	String sql = "SELECT * FROM CursoPropio ";
EstadoCurso estado=EstadoCurso.EN_IMPARTICICION;
	List<CursoPropio> listaCursosPorEstado = CursoPropioDAO.obtenerCursosPorEstado(CursoPropioDAO.obtenerCursos(),estado);
	if(listaCursosPorEstado.size()==0) {
		Assert.assertEquals(listaCursosPorEstado.size(), 0);

	}else {
		Assert.assertNotNull(listaCursosPorEstado);
		}
	}


}
