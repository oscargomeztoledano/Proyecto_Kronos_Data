package negocio.controllers;

import persistencia.CursoPropioDAO;

public class GestorConsultas {

	public static String[] obtenerIngresos() throws Exception {
		return CursoPropioDAO.listarIngresos();
	}
}