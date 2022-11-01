package persistencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import negocio.entities.*;

public class CursoPropioDAO {

	/**
	 * 
	 * @param curso
	 */
	public int crearNuevoCurso(CursoPropio curso) {
		// TODO - implement CursoPropioDAO.crearNuevoCurso
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param curso
	 */
	public CursoPropio seleccionarCurso(CursoPropio curso) {
		// TODO - implement CursoPropioDAO.seleccionarCurso
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param curso
	 */
	public CursoPropio editarCurso(CursoPropio curso) {
		// TODO - implement CursoPropioDAO.editarCurso
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param estado
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public List<CursoPropio> listarCursosPorEstado(EstadoCurso estado, Date fechaInicio, Date fechaFin) {
		// TODO - implement CursoPropioDAO.listarCursosPorEstado
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tipo
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public double listarIngresos(TipoCurso tipo, Date fechaInicio, Date fechaFin) {
		// TODO - implement CursoPropioDAO.listarIngresos
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public void listarEdicionesCursos(Date fechaInicio, Date fechaFin) {
		// TODO - implement CursoPropioDAO.listarEdicionesCursos
		throw new UnsupportedOperationException();
	}

	public List<CursoPropio> obtenerCursos() throws ClassNotFoundException {
		String sql = "Select * FROM CursoPropio";
		Vector<Object> cursos = GestorBD.ExecuteQuery(sql);

		List<CursoPropio> listaCursos = new ArrayList<CursoPropio>();
		int i = 0;
		while (!cursos.isEmpty()) {
			Vector<Object> v = (Vector<Object>) cursos.get(i);
			
			CursoPropio c = new CursoPropio(v.get(0).toString(), v.get(1).toString(), (Integer) v.get(2), (Date) v.get(3),
					(Date) v.get(4), (Double) v.get(5), (Integer) v.get(6));
			
			listaCursos.add(c);

		}
		return listaCursos;
	}

}