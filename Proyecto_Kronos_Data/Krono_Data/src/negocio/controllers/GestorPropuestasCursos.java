package negocio.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import negocio.entities.*;
import persistencia.CentroDAO;
import persistencia.ProfesorDAO;
import persistencia.UsuarioDAO;
import persistencia.CursoPropioDAO;

public class GestorPropuestasCursos {

	public int realizarPropuestaCurso(String nombre, int eCTS, String fechaI, String fechaFin, double tasaMatricula,
            int edicion, String TipoCurso, String centro_nombre, ProfesorUCLM director, String secretarioDni) throws Exception {
		
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//LocalDate fechaInicio = LocalDate.parse(fechaI, formatter);
		//LocalDate fechaFinal = LocalDate.parse(fechaFin, formatter);
		
		SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInicio = fecha.parse(fechaI);
		Date fechaFinal = fecha.parse(fechaFin);
		
		//Period periodo = Period.between(fechaInicio, fechaFinal);
		
		Centro centro = CentroDAO.seleccionarCentro(centro_nombre);
		
		ProfesorUCLM secretario = ProfesorDAO.seleccionarProfesorUCLM(ProfesorDAO.seleccionarProfesor(UsuarioDAO.seleccionarUsuario(secretarioDni)));
		
		TipoCurso tipoCurso = CursoPropioDAO.ComparacionTipoCurso(TipoCurso);
		
		/*switch(tipoCurso) {
			case EXPERTO:
				if (eCTS<15 && eCTS>29) {
					System.err.println("Error. Los créditos para los cursos de tipo experto tienen que estar entre 15 y 29.");
				}
				break;
				
			case MASTER:
				if (eCTS!=60 && eCTS!=90 && eCTS!=120) {
					System.err.println("Error. Los créditos introducidos para másteres deben de ser 60, 90 o 120.");
				}
				else if (periodo.getYears()<2 && eCTS==120) {
					System.err.println("Error. El tiempo para los másteres de 120 ects debe de ser de al menos dos años.");
				}
				else if (periodo.getYears()<1 && eCTS==60) {
					System.err.println("Error. El tiempo para los másteres de 60 ects debe de ser de al menos un año.");
				}
				break;
			
			case ESPECIALISTA:
				if (eCTS!=30 && eCTS!=59) {
					System.err.println("Error. Los créditos introducidos para cursos de tipo especialista deben de ser 30 o 59");
				}
				else if (periodo.getMonths()<6 && eCTS==30) {
					System.err.println("Error. El tiempo para los cursos de tipo especialista de 30 ects debe de ser de al menos 6 meses.");
				}
				else if (periodo.getMonths()<12 && eCTS==59) {
					System.err.println("Error. El tiempo para los cursos de tipo especialista de 59 ects debe de ser de al menos 12 meses.");
				}
				
				break;
				
			case FORMACION_AVANZADA:
				
				if (eCTS<15 && eCTS>30) {
					System.err.println("Error. Los créditos para los cursos de tipo formacion avanzada tienen que estar entre 15 y 30.");
				}
				
				break;
				
			case FORMACION_CONTINUA:
				
				if (eCTS<3 && eCTS>14) {
					System.err.println("Error. Los créditos para los cursos de tipo formacion continua tienen que estar entre 3 y 14.");
				}
				
				break;
				
			case MICROCREDENCIALES:
				
				if (eCTS<2 && eCTS>14) {
					System.err.println("Error. Los créditos para los cursos de tipo microcredenciales tienen que estar entre 2 y 14.");
				}
				
				break;
				
			case CORTA_DURACION:
				
				if (eCTS>=2) {
					System.err.println("Error. Los créditos para los cursos de tipo corta duracion tienen que ser inferiores a 2.");
				}
				else if (periodo.getDays()>1) {
					System.err.println("Error. El tiempo para los cursos de corta duracion debe de ser como máximo de 1 día.");
				}
				
				break;
		}*/
		
		
		CursoPropio curso = new CursoPropio("9", nombre, eCTS, fechaInicio, fechaFinal, tasaMatricula, edicion,
				tipoCurso, EstadoCurso.PROPUESTO, centro, director, secretario);
		
		int resultado=0;
		resultado= CursoPropioDAO.crearNuevoCurso(curso);
		
		
		return resultado;
		
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