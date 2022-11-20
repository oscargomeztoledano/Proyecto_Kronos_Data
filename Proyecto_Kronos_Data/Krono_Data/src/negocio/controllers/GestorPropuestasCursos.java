package negocio.controllers;

import negocio.entities.*;
import persistencia.CursoPropioDAO;

public class GestorPropuestasCursos {

	public CursoPropio realizarPropuestaCurso() {
		// TODO - implement GestorPropuestasCursos.realizarPropuestaCurso
		throw new UnsupportedOperationException();
		
	}

	/**
	 * 
	 * @param curso
	 */
	public void editarPropuestaCurso(CursoPropio curso) {
		// TODO - implement GestorPropuestasCursos.editarPropuestaCurso
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param curso
	 */
	public int evaluarPropuesta(CursoPropio curso,EstadoCurso estado) {
		int resultado=0;
		curso.setEstado(estado);
		CursoPropio cursoActualizado=curso;
		resultado =CursoPropioDAO.editarCurso(cursoActualizado);
		return resultado;
	}

	/**
	 * 
	 * @param curso
	 */
	public void altaCursoAprobado(CursoPropio curso) {
		// TODO - implement GestorPropuestasCursos.altaCursoAprobado
		throw new UnsupportedOperationException();
	}

}