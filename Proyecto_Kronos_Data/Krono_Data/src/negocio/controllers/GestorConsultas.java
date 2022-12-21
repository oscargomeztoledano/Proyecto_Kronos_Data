package negocio.controllers;

import java.util.List;

import negocio.entities.CursoPropio;

import persistencia.CursoPropioDAO;

public class GestorConsultas {
	public static String[] obtenerIngresos() throws Exception {
		return CursoPropioDAO.listarIngresos();
	}
	
	public static List<CursoPropio> ediciones(String edicion) throws Exception {
	
		 List<CursoPropio>cursos = CursoPropioDAO.listarEdicionesCursos(edicion);
		return cursos;
		
	}
}