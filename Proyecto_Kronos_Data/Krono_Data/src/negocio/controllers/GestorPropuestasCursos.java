package negocio.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import negocio.entities.*;
import persistencia.CentroDAO;
import persistencia.ProfesorDAO;
import persistencia.UsuarioDAO;
import persistencia.CursoPropioDAO;

public class GestorPropuestasCursos {

	public void realizarPropuestaCurso(String nombre, int eCTS, String fechaI, String fechaFin, double tasaMatricula,
            int edicion, String TipoCurso, String centro_nombre, ProfesorUCLM director, String secretarioDni) throws Exception {
		
		SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInicio = fecha.parse(fechaI);
		Date fechaFinal = fecha.parse(fechaFin);
		
		Centro centro = CentroDAO.seleccionarCentro(centro_nombre);
		
		ProfesorUCLM secretario = ProfesorDAO.seleccionarProfesorUCLM(ProfesorDAO.seleccionarProfesor(UsuarioDAO.seleccionarUsuario(secretarioDni)));
		
		TipoCurso tipoCurso = CursoPropioDAO.ComparacionTipoCurso(TipoCurso);
		
		switch(tipoCurso) {
			case EXPERTO:
				if (eCTS<15 && eCTS>29) {
					
				}
				break;
		}
		
		
		CursoPropio curso = new CursoPropio("7", nombre, eCTS, fechaInicio, fechaFinal, tasaMatricula, edicion,
				tipoCurso, EstadoCurso.PROPUESTO, centro, director, secretario);
		
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
	public EstadoCurso evaluarPropuesta(CursoPropio curso) {
		// TODO - implement GestorPropuestasCursos.evaluarPropuesta
		throw new UnsupportedOperationException();
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