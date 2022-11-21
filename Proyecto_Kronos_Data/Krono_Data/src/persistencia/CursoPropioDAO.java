package persistencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import negocio.entities.*;
import net.ucanaccess.util.Logger;
import presentacion.PantallaErrores;

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
	public static int editarCurso(CursoPropio curso) {
		int resultado=0;
		
		String sql = "UPDATE CursoPropio SET EstadoCurso = \'"+curso.getEstado()+"\' WHERE id = \'"+curso.getId()+"\'";
		try {
			resultado= GestorBD.ExecuteUpdate(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			Logger.log("mensaje de error");
		}
		return resultado;
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
	 * @throws Exception 
	 */
	public static String[] listarIngresos() throws Exception {
		try {
		String[] ingresos = new String[3];
		String SQL = "SELECT SUM(TasaMatricula) FROM CursoPropio, Matricula WHERE (TipoCurso = \"ESPECIALISTA\" OR TipoCurso = \"MASTER\" OR TipoCurso = \"EXPERTO\") AND (EstadoCurso = \"EN_MATRICULACION\" OR EstadoCurso = \"EN_IMPARTICION\" OR EstadoCurso = \"TERMINADO\") AND Matricula.CursoId = CursoPropio.Id";
		Vector<Object> v = GestorBD.oneExecuteQuery(SQL);
		ingresos[0] = v.get(0).toString();

		SQL = "SELECT SUM(TasaMatricula) FROM CursoPropio, Matricula WHERE (TipoCurso = \"FORMACION_AVANZADA\" OR TipoCurso = \"FORMACION_CONTINUA\") AND (EstadoCurso = \"EN_MATRICULACION\" OR EstadoCurso = \"EN_IMPARTICION\" OR EstadoCurso = \"TERMINADO\") AND Matricula.CursoId = CursoPropio.Id";
		v = GestorBD.oneExecuteQuery(SQL);
		ingresos[1] = v.get(0).toString();

		SQL = "SELECT SUM(TasaMatricula) FROM CursoPropio, Matricula WHERE (TipoCurso = \"MICROCREDENCIALES\" OR TipoCurso = \"CORTA_DURACION\") AND (EstadoCurso = \"EN_MATRICULACION\" OR EstadoCurso = \"EN_IMPARTICION\" OR EstadoCurso = \"TERMINADO\") AND Matricula.CursoId = CursoPropio.Id";
		v = GestorBD.oneExecuteQuery(SQL);
		ingresos[2] = v.get(0).toString();

		return ingresos;
		
		} catch (Exception e) {
			PantallaErrores err = new PantallaErrores(e.toString());
			err.setVisible(true);
			return null;
		}
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

	public static List<CursoPropio> obtenerCursos() throws Exception {
		String sql = "Select * FROM CursoPropio";
		Vector<Object> cursos = GestorBD.ExecuteQuery(sql);

		List<CursoPropio> listaCursos = new ArrayList<CursoPropio>();
		while (!cursos.isEmpty()) {
			@SuppressWarnings("unchecked")
			Vector<Object> v = (Vector<Object>) cursos.get(0);
			ProfesorUCLM dir=ProfesorDAO.seleccionarProfesorUCLM(ProfesorDAO.seleccionarProfesor(UsuarioDAO.seleccionarUsuario(v.get(10).toString())));
			ProfesorUCLM sec=ProfesorDAO.seleccionarProfesorUCLM(ProfesorDAO.seleccionarProfesor(UsuarioDAO.seleccionarUsuario(v.get(11).toString())));

			CursoPropio c = new CursoPropio(v.get(0).toString(), v.get(1).toString(), (Integer) v.get(2),(Date) v.get(3), (Date) v.get(4), (Integer) v.get(5), (Integer) v.get(6),ComparacionTipoCurso(v.get(7).toString()), ComparacionEstadoCurso(v.get(8).toString()),CentroDAO.seleccionarCentro(v.get(9).toString()),dir,sec);

			listaCursos.add(c);

			cursos.remove(0);
		}
		return listaCursos;
	}

	public static List<CursoPropio> obtenerCursosPorTipo(List<CursoPropio> cursos, EstadoCurso estado)
			throws ClassNotFoundException {

		List<CursoPropio> listaCursos = new ArrayList<CursoPropio>();
		while (!cursos.isEmpty()) {
			CursoPropio curso = cursos.get(0);
			if (curso.getEstado().equals(estado)) {
				listaCursos.add(curso);
				
			}
			cursos.remove(0);
		}

		return listaCursos;
	}

	public static TipoCurso ComparacionTipoCurso(String tipocurso) {
		TipoCurso tipo = null;
		switch (tipocurso) {
		case "MASTER":
			tipo = TipoCurso.MASTER;
			break;
		case "EXPERTO":
			tipo = TipoCurso.EXPERTO;
			break;
		case "ESPECIALISTA":
			tipo = TipoCurso.ESPECIALISTA;

			break;
		case "FORMACION_AVANZADA":
			tipo = TipoCurso.FORMACION_AVANZADA;

			break;
		case "FORMACION_CONTINUA":
			tipo = TipoCurso.FORMACION_CONTINUA;
			break;
		case "MICROCREDENCIALES":
			tipo = TipoCurso.MICROCREDENCIALES;

			break;
		case "CORTA_DURACION":
			tipo = TipoCurso.CORTA_DURACION;
			break;

		}
		return tipo;

	}

	public static EstadoCurso ComparacionEstadoCurso(String estadocurso) {
		EstadoCurso estado = null;
		switch (estadocurso) {
		case "PROPUESTO":
			estado = EstadoCurso.PROPUESTO;
			break;
		case "VALIDADO":
			estado = EstadoCurso.VALIDADO;
			break;
		case "PROPUESTA_RECHAZADA":
			estado = EstadoCurso.PROPUESTA_RECHAZADA;

			break;
		case "EN_MATRICULACION":
			estado = EstadoCurso.EN_MATRICULACION;

			break;
		case "EN_IMPARTICION":
			estado = EstadoCurso.EN_IMPARTICICION;
			break;
		case "TERMINADO":
			estado = EstadoCurso.TERMINADO;
			break;
		}
		return estado;

	}

}