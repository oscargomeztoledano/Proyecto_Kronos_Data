package negocio.controllers;

import negocio.entities.*;
import persistencia.MatriculaDAO;
import java.util.Date;

public class GestorMatriculacion {

	public static int realizarMatriculacion(CursoPropio curso, Estudiante estudiante, ModoPago tipoPago) {
		Date fecha = new Date();

		Matricula mat = new Matricula(estudiante, curso, fecha);

		mat = realizarPagoMatricula(curso, estudiante, tipoPago, mat);


		return MatriculaDAO.insert(mat);
	}

	public static Matricula realizarPagoMatricula(CursoPropio curso, Estudiante estudiante, ModoPago tipoPago,
			Matricula mat) {
		
		if (tipoPago==ModoPago.TARJETA_CREDITO) {
			mat.setTipoPago(ModoPago.TARJETA_CREDITO);
			mat.setPagado(true);
		}
		else if (tipoPago==ModoPago.TRANSFERENCIA) {
			mat.setTipoPago(ModoPago.TRANSFERENCIA);
			mat.setPagado(true);
		}
		return mat;
	}

}