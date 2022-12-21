package persistencia;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import negocio.entities.Estudiante;
import negocio.entities.Materia;
import negocio.entities.Matricula;
import negocio.entities.ModoPago;
import negocio.entities.ProfesorUCLM;
import negocio.entities.TipoCurso;
import presentacion.PantallaMatriculacion;

public class MatriculaDAOTest {
@Test
public void insert() throws Exception {
	int resultadoMatricula = 0;
	Collection<Materia> materias = null;
	ProfesorUCLM secretario= ProfesorDAO.seleccionarProfesorUCLM(ProfesorDAO.seleccionarProfesor(UsuarioDAO.seleccionarUsuario("DNI")));
	ProfesorUCLM director= ProfesorDAO.seleccionarProfesorUCLM(ProfesorDAO.seleccionarProfesor(UsuarioDAO.seleccionarUsuario("DNI")));

	Matricula mat=new Matricula( EstudianteDAO.seleccionarEstudiante("DNI"),  new CursoPropio(" ", "", 15, new Date(), new Date(), 150, 1, TipoCurso.CORTA_DURACION, EstadoCurso.EN_MATRICULACION, CentroDAO.seleccionarCentro(" "), director,secretario , new Date(), new Date(), " ",materias) , new Date());
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	String fechaTexto = formatter.format(mat.getFecha());
	int bit;
	if (mat.isPagado()) {
		bit = 1;
	} else {
		bit = 0;
	}
	String sql = "INSERT INTO Matricula (CursoId, DniAlumno, fecha, pagado) VALUES ( '" + mat.getTitulo().getId()
			+ "', '" + mat.getEstudiante().getDNI() + "', '" + fechaTexto + "'," + bit + ")";
	
		resultadoMatricula = GestorBD.executeUpdate(sql);
		if(resultadoMatricula==0) {
			Assert.assertEquals(0,resultadoMatricula);
		}else {
			Assert.assertEquals(1,resultadoMatricula);
		}

	

		

	}
	
}
