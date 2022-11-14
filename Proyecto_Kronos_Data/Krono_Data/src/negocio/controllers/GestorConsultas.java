package negocio.controllers;

import java.util.Vector;

import persistencia.GestorBD;

public class GestorConsultas {

	public static String[] obtenerIngresos() throws Exception {
		String[] ingresos = new String[3];
		String SQL = "SELECT SUM(TasaMatricula) FROM CursoPropio, Matricula WHERE TipoCurso = \"ESPECIALISTA\" OR TipoCurso = \"MASTER\" OR TipoCurso = \"EXPERTO\" AND Matricula.CursoId = CursoPropio.Id";
		Vector<Object> v = GestorBD.oneExecuteQuery(SQL);
		ingresos[0] = v.get(0).toString();

		SQL = "SELECT SUM(TasaMatricula) FROM CursoPropio, Matricula WHERE TipoCurso = \"FORMACION_AVANZADA\" OR TipoCurso = \"FORMACION_CONTINUA\" AND Matricula.CursoId = CursoPropio.Id";
		v = GestorBD.oneExecuteQuery(SQL);
		ingresos[1] = v.get(0).toString();

		SQL = "SELECT SUM(TasaMatricula) FROM CursoPropio, Matricula WHERE TipoCurso = \"MICROCREDENCIALES\" OR TipoCurso = \"CORTA_DURACION\" AND Matricula.CursoId = CursoPropio.Id";
		v = GestorBD.oneExecuteQuery(SQL);
		ingresos[2] = v.get(0).toString();

		return ingresos;
	}
}