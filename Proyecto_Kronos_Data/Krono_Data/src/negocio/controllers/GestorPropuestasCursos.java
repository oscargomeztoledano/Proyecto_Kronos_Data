package negocio.controllers;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import negocio.entities.*;
import net.ucanaccess.util.Logger;
import persistencia.CentroDAO;
import persistencia.ProfesorDAO;
import persistencia.UsuarioDAO;
import persistencia.CursoPropioDAO;
import persistencia.MateriaDAO;

public class GestorPropuestasCursos {

	public int realizarPropuestaCurso(String nombre, int eCTS, String fechaI, String fechaFin, double tasaMatricula,
			int edicion, String tipocurso, String centronombre, ProfesorUCLM director, String secretarioDni,
			String fechaMatriculacion, Collection<Materia> materias) throws Exception {

		SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");

		Date fechaInicio = fecha.parse(fechaI);
		Calendar calInicio = Calendar.getInstance();

		Date fechaFinal = fecha.parse(fechaFin);
		Calendar calFin = Calendar.getInstance();

		Date fechaMatricula = fecha.parse(fechaMatriculacion);
		Centro centro = CentroDAO.seleccionarCentro(centronombre);

		ProfesorUCLM secretario = ProfesorDAO
				.seleccionarProfesorUCLM(ProfesorDAO.seleccionarProfesor(UsuarioDAO.seleccionarUsuario(secretarioDni)));

		TipoCurso tipo = CursoPropioDAO.comparaciontipocurso(tipocurso);

		calInicio.setTime(fechaInicio);
		long lFechaInicio = fechaInicio.getTime() + calInicio.get(Calendar.ZONE_OFFSET)
				+ calInicio.get(Calendar.DST_OFFSET);
		int hrInicio = (int) (lFechaInicio / 3600000); // 60*60*1000
		int diasInicio = (int) hrInicio / 24;

		calFin.setTime(fechaFinal);
		long lFechaFinal = fechaFinal.getTime() + calFin.get(Calendar.ZONE_OFFSET) + calFin.get(Calendar.DST_OFFSET);
		int hrFinal = (int) (lFechaFinal / 3600000);
		int diasFinal = (int) hrFinal / 24;

		double diferenciaAnios = calFin.get(Calendar.YEAR) - calInicio.get(Calendar.YEAR);
		double diferenciaMeses = diferenciaAnios * 12 + calFin.get(Calendar.MONTH) - calInicio.get(Calendar.MONTH);
		double diferenciaDias = diasFinal - diasInicio;

		switch (tipo) {
		case EXPERTO:
			if (eCTS < 15 && eCTS > 29) {
				Logger.log("Error. Los créditos para los cursos de tipo experto tienen que estar entre 15 y 29.");
			}
			break;

		case MASTER:
			if (eCTS != 60 && eCTS != 90 && eCTS != 120) {
				Logger.log("Error. Los créditos introducidos para másteres deben de ser 60, 90 o 120.");
			} else if (diferenciaAnios < 2 && eCTS == 120) {
				Logger.log("Error. El tiempo para los másteres de 120 ects debe de ser de al menos dos años.");
			} else if (diferenciaAnios < 1 && eCTS == 60) {
				Logger.log("Error. El tiempo para los másteres de 60 ects debe de ser de al menos un año.");
			}
			break;

		case ESPECIALISTA:
			if (eCTS != 30 && eCTS != 59) {
				Logger.log("Error. Los créditos introducidos para cursos de tipo especialista deben de ser 30 o 59");
			} else if (diferenciaMeses < 6 && eCTS == 30) {
				Logger.log(
						"Error. El tiempo para los cursos de tipo especialista de 30 ects debe de ser de al menos 6 meses.");
			} else if (diferenciaMeses < 12 && eCTS == 59) {
				Logger.log(
						"Error. El tiempo para los cursos de tipo especialista de 59 ects debe de ser de al menos 12 meses.");
			}

			break;

		case FORMACION_AVANZADA:

			if (eCTS < 15 && eCTS > 30) {
				Logger.log(
						"Error. Los créditos para los cursos de tipo formacion avanzada tienen que estar entre 15 y 30.");
			}

			break;

		case FORMACION_CONTINUA:

			if (eCTS < 3 && eCTS > 14) {
				Logger.log(
						"Error. Los créditos para los cursos de tipo formacion continua tienen que estar entre 3 y 14.");
			}

			break;

		case MICROCREDENCIALES:

			if (eCTS < 2 && eCTS > 14) {
				Logger.log(
						"Error. Los créditos para los cursos de tipo microcredenciales tienen que estar entre 2 y 14.");
			}

			break;

		case CORTA_DURACION:

			if (eCTS >= 2) {
				Logger.log("Error. Los créditos para los cursos de tipo corta duracion tienen que ser inferiores a 2.");
			} else if (diferenciaDias > 1) {
				Logger.log("Error. El tiempo para los cursos de corta duracion debe de ser como máximo de 1 día.");
			}

			break;
		}

		SecureRandom r = new SecureRandom();
		CursoPropio curso = new CursoPropio(String.valueOf(r.nextInt(1000)), nombre, eCTS, fechaInicio, fechaFinal,
				tasaMatricula, edicion, tipo, EstadoCurso.PROPUESTO, centro, director, secretario, new Date(),
				fechaMatricula, " ");

		int resultado = 0;

		resultado = CursoPropioDAO.crearNuevoCurso(curso);

		for (Materia m : materias) {
			if ((m.getFechaInicio().after(curso.getFechaInicio()) && m.getFechaFin().before(curso.getFechaFin()))
					|| (m.getFechaInicio().equals(curso.getFechaInicio())
							&& m.getFechaFin().equals(curso.getFechaFin()))) {

				m.setResponsable(ProfesorDAO.seleccionarProfesor(UsuarioDAO.seleccionarUsuario(m.getDniProfesor())));

				resultado = MateriaDAO.insertarMateriaCurso(m, curso);
			} else
				Logger.log(
						"Error. La fecha de la materia debe de estar comprendida entre la fecha incio y fin del curso");
		}
		return resultado;

	}

	/**
	 * 
	 * @param curso
	 * @throws Exception 
	 */
	public int editarPropuestaCurso(String id, String nombre, int eCTS, String fechaI, String fechaFin, double tasaMatricula,
            int edicion, String tipocurso, String centronombre, ProfesorUCLM director, String secretarioDni,String fechaMatriculacion, Collection<Materia> materias) throws Exception {
		
		int resultado = 0;
		
		SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
		
		Date fechaInicio = fecha.parse(fechaI);
		Date fechaFinal = fecha.parse(fechaFin);
		Date fechaMatricula=fecha.parse(fechaMatriculacion);
		
		Centro centro = CentroDAO.seleccionarCentro(centronombre);
		
		ProfesorUCLM secretario = ProfesorDAO.seleccionarProfesorUCLM(ProfesorDAO.seleccionarProfesor(UsuarioDAO.seleccionarUsuario(secretarioDni)));
		
		TipoCurso tipo = CursoPropioDAO.comparaciontipocurso(tipocurso);
		
		CursoPropio curso = new CursoPropio(id, nombre, eCTS, fechaInicio, fechaFinal, tasaMatricula, edicion,
				tipo, EstadoCurso.PROPUESTO, centro, director, secretario,new Date(),fechaMatricula,"Nada");
		
		resultado = CursoPropioDAO.editarCursos(curso);
		
		return resultado;
	}

	/**
	 * 
	 * @param curso
	 */
	public int evaluarPropuesta(CursoPropio curso, EstadoCurso estado, String motivo) {
		int resultado = 0;
		curso.setEstado(estado);
		curso.setMotivoRechazo(motivo);
		curso.setUltimaModificacion(new Date());
		resultado = CursoPropioDAO.editarCurso(curso);
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