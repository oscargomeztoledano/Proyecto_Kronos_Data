package negocio.controllers;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import negocio.entities.CursoPropio;
import persistencia.CursoPropioDAO;

public class GestorConsultasTest {
@Test 
public void testobtenerListaIngresos() throws Exception {
	String[] listaIngresos=GestorConsultas.obtenerIngresos();
	Assert.assertNotNull(listaIngresos);
}
@Test 
public void testediciones() throws Exception {
	String edicion="1";
	 List<CursoPropio>cursos = CursoPropioDAO.listarEdicionesCursos(edicion);
	 if(cursos==null) {
		 Assert.assertNull(cursos);
	 }else {
		 Assert.assertNotNull(cursos);
	 }
}
}
