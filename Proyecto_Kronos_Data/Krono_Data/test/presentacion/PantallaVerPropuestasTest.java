package presentacion;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import persistencia.CursoPropioDAO;

public class PantallaVerPropuestasTest {
	
public void testrellenarTabla() throws Exception {
	List<CursoPropio> cursos = CursoPropioDAO.obtenerCursosPorTipo(CursoPropioDAO.obtenerCursos(), EstadoCurso.PROPUESTO);
	assertNotNull(cursos);
}
}
