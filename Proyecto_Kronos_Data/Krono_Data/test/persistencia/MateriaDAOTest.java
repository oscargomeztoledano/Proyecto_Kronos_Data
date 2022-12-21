package persistencia;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;

import negocio.entities.CursoPropio;
import negocio.entities.Materia;
import negocio.entities.Profesor;

public class MateriaDAOTest {
@Test
public void testinsertarMateriaCurso() {
	int resultado = 0;


	Materia materia= new Materia(new Profesor(null, null, null, null, null, false), null, resultado, new Date(resultado), new Date(resultado));
	CursoPropio curso= new CursoPropio(null, null, resultado, null, null, resultado, resultado, null, null, null, null, null, null, null, null, null);
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	String fechaIn = formatter.format(materia.getFechaInicio());
	String fechaFinal = formatter.format(materia.getFechaFin());

		String sql = "INSERT INTO Materia (Nombre, Horas, fechaInicio, fechaFin, CursoId, dniProfesor) VALUES"
				+ " ('"+ materia.getNombre() +"', "+ materia.getHoras() +", '"+ fechaIn +"', '"+ fechaFinal +"', '"+ curso.getId() +"', "
						+"'"+ materia.getResponsable().getDNI() +"')";

		resultado = GestorBD.executeUpdate(sql);
		if(resultado==0) {
			Assert.assertEquals(0,resultado);
		}else {
			Assert.assertEquals(1,resultado);
		}
		
}
}
