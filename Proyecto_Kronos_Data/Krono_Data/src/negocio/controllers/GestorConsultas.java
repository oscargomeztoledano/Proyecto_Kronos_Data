package negocio.controllers;

import java.util.Vector;

import persistencia.CursoPropioDAO;
import persistencia.GestorBD;

public class GestorConsultas {

	public static String[] obtenerIngresos() throws Exception {
		return CursoPropioDAO.listarIngresos();
	}
}