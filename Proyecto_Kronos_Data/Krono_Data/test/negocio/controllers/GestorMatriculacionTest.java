package negocio.controllers;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import negocio.entities.CategoriaProfesor;
import negocio.entities.Centro;
import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;
import negocio.entities.Estudiante;
import negocio.entities.Matricula;
import negocio.entities.ModoPago;
import negocio.entities.ProfesorUCLM;
import negocio.entities.TipoCurso;
import persistencia.MatriculaDAO;
import presentacion.PantallaErrores;

public class GestorMatriculacionTest {
@Test
public void testrealizarMatriculacion() {
	ProfesorUCLM director= new ProfesorUCLM("12345678P","123","P", "Nombre", "Apellidos", true,CategoriaProfesor.AYUDANTE,
			new Centro("nombre","localizacion"));
	ProfesorUCLM secretario= new ProfesorUCLM("23456789P","123","P", "Nombre", "Apellidos", true,CategoriaProfesor.AYUDANTE,
			new Centro("nombre","localizacion"));
	Date fechaInicio=new Date(122,9,9);
	Date fechaFin=new Date(123,1,1);
	Date fechamat=new Date(122,9,1);
	CursoPropio curso = new CursoPropio("0", "Curso4", 16, fechaInicio, fechaFin,
			160, 1, TipoCurso.ESPECIALISTA, EstadoCurso.PROPUESTO, new Centro("Salud","Talavera"), director, secretario, new Date(),
			fechamat, " ");	Estudiante estudiante = new Estudiante(null, null, null, null, null);
	ModoPago tipoPago= ModoPago.TARJETA_CREDITO;
	
	int resultado=0;
	Calendar calendar= Calendar.getInstance();
	Date fecha = new Date();
	Date fechaMatriculacion=curso.getFechaMatriculacion();
	calendar.setTime(curso.getFechaInicio());
	calendar.add(Calendar.DAY_OF_YEAR, -1);
	Date fechaFinMatriculacion=calendar.getTime();

	if(fecha.getTime()>=fechaMatriculacion.getTime()&& fecha.getTime()<=fechaFinMatriculacion.getTime()) {
	
		Matricula mat = new Matricula(estudiante, curso, fecha);
	

		mat = GestorMatriculacion.realizarPagoMatricula(curso, estudiante, tipoPago, mat);


		resultado= MatriculaDAO.insert(mat);
		
	}else {
		PantallaErrores err = new PantallaErrores("No se puede matricular ya que ha expirado la fecha de matriculacion");
		err.setVisible(true);
	}
	
	if(resultado==0) {
		Assert.assertEquals(resultado, 0);
	}else {
		Assert.assertEquals(resultado, 1);
	}
	
}
}
