package persistencia;

import java.text.SimpleDateFormat;
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
	 * @throws Exception
	 * @throws ClassNotFoundException
	 */
	public static int crearNuevoCurso(CursoPropio curso) {
		int resultado = 0;
		Date actual = new Date();
		List<CursoPropio> cursos = null;
		try {
			cursos = obtenerCursos();
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
		for (CursoPropio c : cursos) {
			if (c.equals(curso)) {
				PantallaErrores err = new PantallaErrores("No se puede proponer un mismo curso, con la misma edición");
				err.setVisible(true);

return resultado;
			} else if (c.getNombre().equals(curso.getNombre())) {
				PantallaErrores err = new PantallaErrores("Ese nombre ya esta en uso");
				err.setVisible(true);
				return resultado;
			} else if (c.getNombre().equals(curso.getNombre()) && c.getEdicion() != curso.getEdicion()
					&& !(c.getEstado().equals(EstadoCurso.TERMINADO))) {
				PantallaErrores err = new PantallaErrores(
						"El curso que la edicion pasada necesita estar terminado para poder proponer la siguiente edicion");
				err.setVisible(true);
				return resultado;
			}
		}
		try {
			resultado = GestorBD.executeUpdate(sql);
		} catch (Exception e) {
			PantallaErrores err = new PantallaErrores(e.toString());
			err.setVisible(true);
			return resultado;

		}

		return resultado;
	}





	public static int editarCurso(CursoPropio curso) {
		int resultado = 0;

		Date actual = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String fechaIn = formatter.format(curso.getFechaInicio());
		String fechaFinal = formatter.format(curso.getFechaFin());
		String fechaMatricula = formatter.format(curso.getFechaMatriculacion());
		String fechaActual = formatter.format(actual);

		String sql = "UPDATE CursoPropio SET EstadoCurso = \'" + String.valueOf(curso.getEstado()) + "\' , nombre = \'"
				+ curso.getNombre() + "\', ECTS = " + curso.getEcts() + ", FechaInicio = \'" + fechaIn
				+ "\', FechaFin = \'" + fechaFinal + "\'" + ", TasaMatricula = " + curso.getTasaMatricula()
				+ ", Edicion = " + curso.getEdicion() + ", TipoCurso = \'" + String.valueOf(curso.getTipo())
				+ "\', Nombre_Centro = \'" + curso.getCentro().getNombre() + "\'" + ", Director = \'"
				+ curso.getDirector().getDNI() + "\', Secretario = \'" + curso.getSecretario().getDNI()
				+ "\', Ultima_Modificacion = \'" + fechaActual + "\' , FechaMatricula = \'" + fechaMatricula + "\'"
				+ ", Motivo_Rechazo = \'" + curso.getMotivoRechazo() + "\'WHERE id = \'" + curso.getId() + "\'";

		try {
			resultado = GestorBD.executeUpdate(sql);
		} catch (Exception e) {
			PantallaErrores err = new PantallaErrores(e.toString());
			err.setVisible(true);
		}
		return resultado;
	}




	public static String[] listarIngresos() throws Exception {

		String[] ingresos = new String[3];
		String SQL = "SELECT SUM(TasaMatricula) FROM dbo.CursoPropio, dbo.Matricula WHERE (CursoPropio.TipoCurso = 'ESPECIALISTA' OR CursoPropio.TipoCurso = 'MASTER' OR CursoPropio.TipoCurso = 'EXPERTO') AND (CursoPropio.EstadoCurso = 'EN_MATRICULACION' OR CursoPropio.EstadoCurso = 'EN_IMPARTICION' OR CursoPropio.EstadoCurso = 'TERMINADO') AND dbo.Matricula.CursoId = CursoPropio.Id";

		Vector<Object> v = GestorBD.oneExecuteQuery(SQL);

		try {
			ingresos[0] = v.get(0).toString();
		} catch (NullPointerException e) {
			ingresos[0]="0";
		}
		SQL = "SELECT SUM(TasaMatricula) FROM dbo.CursoPropio, dbo.Matricula WHERE (CursoPropio.TipoCurso = 'FORMACION_AVANZADA' OR CursoPropio.TipoCurso = 'FORMACION_CONTINUA') AND (CursoPropio.EstadoCurso = 'EN_MATRICULACION' OR CursoPropio.EstadoCurso = 'EN_IMPARTICION' OR CursoPropio.EstadoCurso ='TERMINADO') AND Matricula.CursoId = CursoPropio.Id";
		v = GestorBD.oneExecuteQuery(SQL);

		try {
			ingresos[1] = v.get(0).toString();

		} catch (NullPointerException e) {
			ingresos[1]="0";
		}

		SQL = "SELECT SUM(TasaMatricula) FROM dbo.CursoPropio, dbo.Matricula WHERE (CursoPropio.TipoCurso = 'MICROCREDENCIALES\' OR CursoPropio.TipoCurso = 'CORTA_DURACION') AND (CursoPropio.EstadoCurso = 'EN_MATRICULACION' OR CursoPropio.EstadoCurso = 'EN_IMPARTICION' OR CursoPropio.EstadoCurso = 'TERMINADO') AND Matricula.CursoId = CursoPropio.Id";
		v = GestorBD.oneExecuteQuery(SQL);

		try {
			ingresos[2] = v.get(0).toString();

		} catch (NullPointerException e) {
			ingresos[2]="0";
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
	public static List<CursoPropio> listarEdicionesCursos(String edicion) {
		String sql = "SELECT * FROM dbo.CursoPropio WHERE Edicion =" + edicion;
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
		if(cursos!=null) {
		listaCursos = recogerCursos(cursos, listaCursos);
		}
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

	public static List<CursoPropio> obtenerCursosPorEstado(List<CursoPropio> cursos, EstadoCurso estado) {

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