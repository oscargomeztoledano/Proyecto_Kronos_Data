package negocio.controllers;

import negocio.entities.*;
import persistencia.MatriculaDAO;
import presentacion.PantallaMatriculacion;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GestorMatriculacion {

	public static void realizarMatriculacion(CursoPropio curso, Estudiante estudiante, ModoPago tipoPago)  {
		Date fecha = new Date();
		
		
		Matricula mat = new Matricula(estudiante, curso, fecha);
		
		mat = realizarPagoMatricula(curso, estudiante, tipoPago, mat);
		
		try {
			MatriculaDAO.insert(mat);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			PantallaMatriculacion.jTextArea1.setText("Ha ocurrido un problema con la matricula");
			e.printStackTrace();
		}

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