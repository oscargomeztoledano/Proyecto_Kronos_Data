package negocio.controllers;

import negocio.entities.*;
import persistencia.MatriculaDAO;
import presentacion.PantallaErrores;

import java.util.Calendar;
import java.util.Date;

public class GestorMatriculacion {

	public static int realizarMatriculacion(CursoPropio curso, Estudiante estudiante, ModoPago tipoPago) {
		int resultado=0;
		Calendar calendar= Calendar.getInstance();
		Date fecha = new Date();
		Date fechaMatriculacion=curso.getFechaMatriculacion();
		calendar.setTime(fechaMatriculacion);
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		Date fechaFinMatriculacion=calendar.getTime();
		if(fecha.getTime()>=fechaMatriculacion.getTime()&& fecha.getTime()<=fechaFinMatriculacion.getTime()) {
		
		
			Matricula mat = new Matricula(estudiante, curso, fecha);
		

			mat = realizarPagoMatricula(curso, estudiante, tipoPago, mat);


			resultado= MatriculaDAO.insert(mat);
			
		}else {
			PantallaErrores err = new PantallaErrores("No se puede matricular ya que todavia no esta en la fecha");
			err.setVisible(true);
		}
		
		return resultado;
				
		
		
		
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