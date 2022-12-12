package persistencia;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import negocio.entities.*;
import presentacion.PantallaErrores;

public class CursoPropioDAO {

	/**
	 * 
	 * @param curso
	 * @throws ClassNotFoundException
	 */
	public static int crearNuevoCurso(CursoPropio curso) {
		int resultado = 0;
		Date actual = new Date();
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

		try {
			resultado = GestorBD.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			PantallaErrores err = new PantallaErrores(e.toString());
			err.setVisible(true);
		}

		return resultado;
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
		int resultado = 0;
		
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
		} catch (ClassNotFoundException e) {
			PantallaErrores err = new PantallaErrores(e.toString());
			err.setVisible(true);
		}
		return resultado;
	}
	

	/**
	 * 
	 * @param estado
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public List<CursoPropio> listarCursosPorEstado(EstadoCurso estado, LocalDate fechaInicio, LocalDate fechaFin) {
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

	public static String[] listarIngresos() throws Exception  {
		
			String[] ingresos = new String[3];
			String SQL = "SELECT SUM(TasaMatricula) FROM CursoPropio, Matricula WHERE (TipoCurso = \"ESPECIALISTA\" OR TipoCurso = \"MASTER\" OR TipoCurso = \"EXPERTO\") AND (EstadoCurso = \"EN_MATRICULACION\" OR EstadoCurso = \"EN_IMPARTICION\" OR EstadoCurso = \"TERMINADO\") AND Matricula.CursoId = CursoPropio.Id";
	 
					Vector<Object> v = GestorBD.oneExecuteQuery(SQL);
			
			if(v.equals(null)) {
				v.add(0, "0");
				ingresos[0] = v.get(0).toString();
			}else {
			ingresos[0] = v.get(0).toString();
			}
			SQL = "SELECT SUM(TasaMatricula) FROM CursoPropio, Matricula WHERE (TipoCurso = \"FORMACION_AVANZADA\" OR TipoCurso = \"FORMACION_CONTINUA\") AND (EstadoCurso = \"EN_MATRICULACION\" OR EstadoCurso = \"EN_IMPARTICION\" OR EstadoCurso = \"TERMINADO\") AND Matricula.CursoId = CursoPropio.Id";
			v = GestorBD.oneExecuteQuery(SQL);
			if(v.equals(null)) {
				v.add(0, "0");
				ingresos[1] = v.get(0).toString();
			}else {
			ingresos[1] = v.get(0).toString();
			}

			SQL = "SELECT SUM(TasaMatricula) FROM CursoPropio, Matricula WHERE (TipoCurso = \"MICROCREDENCIALES\" OR TipoCurso = \"CORTA_DURACION\") AND (EstadoCurso = \"EN_MATRICULACION\" OR EstadoCurso = \"EN_IMPARTICION\" OR EstadoCurso = \"TERMINADO\") AND Matricula.CursoId = CursoPropio.Id";
			v = GestorBD.oneExecuteQuery(SQL);
			if(v.equals(null)) {
				v.add(0, "0");
				ingresos[2] = v.get(0).toString();
			}else {
			ingresos[2] = v.get(0).toString();
			}

			return ingresos;

		
	}

	/**
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 * @return
	 * @throws Exception
	 */
	public static List<CursoPropio> listarEdicionesCursos(String edicion)  {
		String sql = "SELECT * FROM CursoPropio WHERE Edicion = \"" + edicion + "\"";
		Vector<Object> v;
		try {
			v = GestorBD.executeQuery(sql);
		
		List<CursoPropio> listaCursos = new ArrayList<>();
		listaCursos = recogerCursos(v, listaCursos);

		return listaCursos;

		} catch (Exception e) {
			PantallaErrores err = new PantallaErrores(e.toString());
			err.setVisible(true);
		}
		return null;
		


	}

	public static List<CursoPropio> obtenerCursos() throws Exception {
		String sql = "SELECT * FROM CursoPropio ";
		Vector<Object> cursos = null;
		try {
			cursos = GestorBD.executeQuery(sql);
		} catch (ClassNotFoundException e) {
			PantallaErrores err = new PantallaErrores(e.toString());
			err.setVisible(true);
		}

		List<CursoPropio> listaCursos = new ArrayList<CursoPropio>();

		listaCursos = recogerCursos(cursos, listaCursos);
		return listaCursos;
	}

	public static List<CursoPropio> recogerCursos(Vector<Object> c, List<CursoPropio> listaCursos) throws Exception {
		while (!c.isEmpty()) {
			Vector<Object> v = (Vector<Object>) c.get(0);
			ProfesorUCLM dir = ProfesorDAO.seleccionarProfesorUCLM(
					ProfesorDAO.seleccionarProfesor(UsuarioDAO.seleccionarUsuario(v.get(10).toString())));
			ProfesorUCLM sec = ProfesorDAO.seleccionarProfesorUCLM(
					ProfesorDAO.seleccionarProfesor(UsuarioDAO.seleccionarUsuario(v.get(11).toString())));
			CursoPropio curso = new CursoPropio(v.get(0).toString(), v.get(1).toString(), (Integer) v.get(2),
					(Date) v.get(3), (Date) v.get(4), (Double) v.get(5), (Integer) v.get(6),
					comparaciontipocurso(v.get(7).toString()), comparacionestadocurso(v.get(8).toString()),
					CentroDAO.seleccionarCentro(v.get(9).toString()), dir, sec, (Date) v.get(12), (Date) v.get(13),
					v.get(14).toString());

			listaCursos.add(curso);
			c.remove(0);

		}

		return listaCursos;
	}

	public static List<CursoPropio> obtenerCursosPorTipo(List<CursoPropio> cursos, EstadoCurso estado) {

		List<CursoPropio> listaCursos = new ArrayList<>();
		while (!cursos.isEmpty()) {
			CursoPropio curso = cursos.get(0);
			if (curso.getEstado().equals(estado)) {
				listaCursos.add(curso);

			}
			cursos.remove(0);
		}

		return listaCursos;
	}

	

	public static TipoCurso comparaciontipocurso(String tipocurso) {
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

	public static EstadoCurso comparacionestadocurso(String estadocurso) {
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