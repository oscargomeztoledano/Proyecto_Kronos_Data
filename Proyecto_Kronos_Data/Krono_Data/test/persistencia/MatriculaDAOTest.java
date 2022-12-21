package persistencia;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import negocio.entities.CursoPropio;
import negocio.entities.Estudiante;
import negocio.entities.Matricula;
import negocio.entities.ModoPago;
import presentacion.PantallaMatriculacion;

public class MatriculaDAOTest {
@Test
public void insert() {
	int resultadoMatricula = 0;
	
	Matricula mat=new Matricula( new Estudiante(null, null, null, null, null, null, null, null),  new CursoPropio(null, null, resultadoMatricula, null, null, resultadoMatricula, resultadoMatricula, null, null, null, null, null, null, null, null, null) , new Date());
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
