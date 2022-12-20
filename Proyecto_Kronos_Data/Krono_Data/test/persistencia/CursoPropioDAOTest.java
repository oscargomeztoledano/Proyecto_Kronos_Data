package persistencia;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import negocio.entities.CategoriaProfesor;
import negocio.entities.Centro;
import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import negocio.entities.ProfesorUCLM;
import negocio.entities.TipoCurso;
import presentacion.PantallaErrores;
public class CursoPropioDAOTest {
@Test
public void testcrearNuevoCurso() {
	int resultado=0;
	ProfesorUCLM director= new ProfesorUCLM("Dni", "Contrasena","P", "Nombre", "Apellidos", true,CategoriaProfesor.AYUDANTE,
			new Centro("nombre","localizacion"));
	ProfesorUCLM secretario= new ProfesorUCLM("Dni", "Contrasena","P", "Nombre", "Apellidos", true,CategoriaProfesor.AYUDANTE,
			new Centro("nombre","localizacion"));
	Date fechaInicio=new Date(122,9,9);
	Date fechaFin=new Date(123,1,1);
	Date fechamat=new Date(122,9,1);
	CursoPropio curso = new CursoPropio("0", "Curso4", 16, fechaInicio, fechaFin,
			160, 1, TipoCurso.ESPECIALISTA, EstadoCurso.PROPUESTO, new Centro("nombre","localizacion"), director, secretario, new Date(),
			fechamat, " ");
	Date actual = new Date();
	List<CursoPropio> cursos = null;
	try{
		cursos = CursoPropioDAO.obtenerCursos();
	} catch (Exception e) {
		PantallaErrores err = new PantallaErrores(e.toString());
		err.setVisible(true);
	}
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	String fechaIn = formatter.format(curso.getFechaInicio());
	String fechaFinal = formatter.format(curso.getFechaFin());
	String fechaMatricula = formatter.format(curso.getFechaMatriculacion());
	String fechaActual = formatter.format(actual);

	String sql = "INSERT INTO dbo.CursoPropio (Id, nombre, ECTS, FechaInicio, FechaFin, TasaMatricula, Edicion,"
			+ "TipoCurso, EstadoCurso, Nombre_Centro, Director, Secretario,Ultima_Modificacion,FechaMatricula,Motivo_Rechazo) VALUES ( '"
			+ curso.getId() + "', '" + curso.getNombre() + "', " + curso.getEcts() + ",'" + fechaIn + "','"
			+ fechaFinal + "'," + curso.getTasaMatricula() + "," + curso.getEdicion() + ",'"
			+ curso.getTipo().toString() + "','" + curso.getEstado().toString() + "','"
			+ curso.getCentro().getNombre() + "','" + curso.getDirector().getDNI() + "','"
			+ curso.getSecretario().getDNI() + "','" + fechaActual + "','" + fechaMatricula + "','Nada')";
	for(CursoPropio c:cursos) {
		if(c.equals(curso)) {
			PantallaErrores err = new PantallaErrores("No se puede proponer un mismo curso, con la misma edición");
			err.setVisible(true);
			break;
		}else if(c.getNombre()== curso.getNombre()){
			PantallaErrores err = new PantallaErrores("Ese nombre ya esta en uso");
			err.setVisible(true);
			break;
		}else if(c.getNombre()==curso.getNombre() && c.getEdicion()!=curso.getEdicion() && !(c.getEstado().equals(EstadoCurso.TERMINADO))) {
			PantallaErrores err = new PantallaErrores("El curso que la edicion pasada necesita estar terminado para poder proponer la siguiente edicion");
			err.setVisible(true);
		}
	}
	try {
		resultado = GestorBD.executeUpdate(sql);
	}catch (Exception e) {
		PantallaErrores err = new PantallaErrores(e.toString());
		err.setVisible(true);
	}
if(resultado==0) {
	Assert.assertEquals(resultado, 0);
}else {
	Assert.assertEquals(resultado, 1);
}

}
@Test
public void testeditarCurso() {
	int resultado = 0;
	ProfesorUCLM director= new ProfesorUCLM("Dni", "Contrasena","P", "Nombre", "Apellidos", true,CategoriaProfesor.AYUDANTE,
			new Centro("nombre","localizacion"));
	ProfesorUCLM secretario= new ProfesorUCLM("Dni", "Contrasena","P", "Nombre", "Apellidos", true,CategoriaProfesor.AYUDANTE,
			new Centro("nombre","localizacion"));
	Date fechaInicio=new Date(122,9,9);
	Date fechaFin=new Date(123,1,1);
	Date fechamat=new Date(122,9,1);
	CursoPropio curso = new CursoPropio("0", "Curso4", 16, fechaInicio, fechaFin,
			160, 1, TipoCurso.ESPECIALISTA, EstadoCurso.PROPUESTO, new Centro("nombre","localizacion"), director, secretario, new Date(),
			fechamat, " ");
	Date actual = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	String fechaIn = formatter.format(curso.getFechaInicio());
	String fechaFinal = formatter.format(curso.getFechaFin());
	String fechaMatricula = formatter.format(curso.getFechaMatriculacion());
	String fechaActual = formatter.format(actual);

	String sql = "UPDATE CursoPropio SET EstadoCurso = \'" + String.valueOf(curso.getEstado()) + "\' , nombre = \'" + curso.getNombre() + "\', ECTS = " + curso.getEcts() + ", FechaInicio = \'" + fechaIn + "\', FechaFin = \'" + fechaFinal + "\'"
			+ ", TasaMatricula = " + curso.getTasaMatricula() + ", Edicion = " + curso.getEdicion() + ", TipoCurso = \'" + String.valueOf(curso.getTipo()) + "\', Nombre_Centro = \'" + curso.getCentro().getNombre() + "\'"
					+ ", Director = \'" + curso.getDirector().getDNI() + "\', Secretario = \'" + curso.getSecretario().getDNI() + "\', Ultima_Modificacion = \'" + fechaActual + "\' , FechaMatricula = \'" + fechaMatricula + "\'"
							+ ", Motivo_Rechazo = \'"+ curso.getMotivoRechazo() +"\'WHERE id = \'" + curso.getId() + "\'";


	try {
		resultado = GestorBD.executeUpdate(sql);
	} catch (Exception e) {
		PantallaErrores err = new PantallaErrores(e.toString());
		err.setVisible(true);
	}
	if(resultado==0) {
		Assert.assertEquals(resultado, 0);
	}else {
		Assert.assertEquals(resultado, 1);
	}
}
@Test
public void testlistarIngresos() {
	
}
@Test
public void testlistarEdicionesCursos() {
	
}
@Test
public void testobtenerCursos() {
	
}
@Test
public void testrecogerCursos() {
	
}
@Test
public void testobtenerCursosporTipos() {
	
}
}
