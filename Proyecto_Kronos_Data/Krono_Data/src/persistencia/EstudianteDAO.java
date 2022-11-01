package persistencia;

import java.util.Vector;

import negocio.entities.*;

public class EstudianteDAO<E> {

	

	public static Estudiante seleccionarEstudiante(String DNI) throws Exception {
		String SQL = "SELECT * FROM estudiante WHERE Dni =\'"+DNI+"\'";

		Vector<Object> estudiante = GestorBD.oneExecuteQuery(SQL);
		Estudiante est = new Estudiante(estudiante.get(0).toString(), estudiante.get(1).toString(),
				estudiante.get(2).toString(), estudiante.get(3).toString(), estudiante.get(4).toString());

		return est;
	}

}