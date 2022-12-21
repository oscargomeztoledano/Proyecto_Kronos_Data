package persistencia;

import java.util.Vector;

import negocio.entities.*;

public class EstudianteDAO<E> {

	

	public static Estudiante seleccionarEstudiante(String dni) throws Exception {
		String sql = "SELECT * FROM Estudiante WHERE Dni ='"+dni+"'";

		Vector<Object> estudiante = GestorBD.oneExecuteQuery(sql);
		

		return new Estudiante(estudiante.get(0).toString(), estudiante.get(1).toString(),estudiante.get(2).toString(), estudiante.get(3).toString(), estudiante.get(4).toString());
	}

}