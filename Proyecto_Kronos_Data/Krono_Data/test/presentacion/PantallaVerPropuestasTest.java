package presentacion;

import  org.junit.Assert;
import org.junit.Test;

import java.util.List;


import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import persistencia.CursoPropioDAO;

public class PantallaVerPropuestasTest {
	@Test
public void testrellenarTabla() throws Exception {
	List<CursoPropio> cursos = CursoPropioDAO.obtenerCursosPorEstado(CursoPropioDAO.obtenerCursos(), EstadoCurso.PROPUESTO);
	if(cursos.equals(null)) {
		Assert.assertEquals(cursos, null);
	}else {
		Assert.assertNotNull(cursos);
	}
}
}
