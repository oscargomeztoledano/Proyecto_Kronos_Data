package negocio.controllers;

import negocio.entities.*;
import persistencia.MatriculaDAO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GestorMatriculacion {

	public static void realizarMatriculacion(CursoPropio curso, Estudiante estudiante, ModoPago tipoPago) throws ClassNotFoundException {
		Date fecha = new Date();
		
		
		Matricula mat = new Matricula(estudiante, curso, fecha);
		
		mat = realizarPagoMatricula(curso, estudiante, tipoPago, mat);
		
		MatriculaDAO.insert(mat);

	}

	public static Matricula realizarPagoMatricula(CursoPropio curso, Estudiante estudiante, ModoPago tipoPago, Matricula mat) {
		switch (tipoPago) {
		case TARJETA_CREDITO:
			mat.setTipoPago(ModoPago.TARJETA_CREDITO);
			mat.setPagado(true);
			break;

		case TRANSFERENCIA:
			mat.setTipoPago(ModoPago.TRANSFERENCIA);
			mat.setPagado(true);
			break;
		}
		return mat;
	}

}