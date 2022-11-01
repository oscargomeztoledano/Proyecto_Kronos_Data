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
	public static List<CursoPropio> obtenerCursos() throws ClassNotFoundException {
		String sql = "Select * FROM CursoPropio";
		Vector<Object> cursos = GestorBD.ExecuteQuery(sql);

		List<CursoPropio> listaCursos = new ArrayList<CursoPropio>();
		while (!cursos.isEmpty()) {
			Vector<Object> v = (Vector<Object>) cursos.get(0);
			
			CursoPropio c = new CursoPropio(v.get(0).toString(), v.get(1).toString(), (Integer) v.get(2), (Date) v.get(3),(Date) v.get(4), (Integer) v.get(5), (Integer) v.get(6), ComparacionTipoCurso(v.get(7).toString()),ComparacionEstadoCurso(v.get(8).toString()));
			if(c.getEstado().equals(EstadoCurso.EN_MATRICULACION)) {
			listaCursos.add(c);
			}
			cursos.remove(0);
		}
		return listaCursos;
	}
	public static TipoCurso ComparacionTipoCurso(String tipocurso) {
		TipoCurso tipo=null;
		switch(tipocurso) {
		case "MASTER":
			tipo=TipoCurso.MASTER;
			break;
		case "EXPERTO":
			tipo=TipoCurso.EXPERTO;
			break;
		case "ESPECIALISTA":
			tipo=TipoCurso.ESPECIALISTA;

			break;
		case "FORMACION_AVANZADA":
			tipo=TipoCurso.FORMACION_AVANZADA;

			break;
		case "FORMACION_CONTINUA":
			tipo=TipoCurso.FORMACION_CONTINUA;
			break;
		case "MICROCREDENCIALES":
			tipo=TipoCurso.MICROCREDENCIALES;

			break;
		case "CORTA_DURACION":
			tipo=TipoCurso.CORTA_DURACION;
			break;
		
		}
		return tipo;
		
	}
	public static EstadoCurso ComparacionEstadoCurso(String estadocurso) {
		EstadoCurso estado=null;
		switch(estadocurso) {
		case "PROPUESTO":
			estado=EstadoCurso.PROPUESTO;
			break;
		case "VALIDADO":
			estado=EstadoCurso.VALIDADO;
			break;
		case "PROPUESTA_RECHAZADA":
			estado=EstadoCurso.PROPUESTA_RECHAZADA;

			break;
		case "EN_MATRICULACION":
			estado=EstadoCurso.EN_MATRICULACION;

			break;
		case "EN_IMPARTIZICION":
			estado=EstadoCurso.EN_IMPARTIZICION;
			break;
		case "TERMINADO":
			estado=EstadoCurso.TERMINADO;
			break;
		}
		return estado;
		
	}
	

}