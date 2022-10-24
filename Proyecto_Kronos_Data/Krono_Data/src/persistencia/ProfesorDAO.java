package persistencia;

import java.util.Vector;

import negocio.entities.Profesor;
import negocio.entities.Usuario;

public class ProfesorDAO {
	public static Vector<Object> get(String SQL) throws Exception {
		Vector<Object> profesor = GestorBD.oneExecuteQuery(SQL);

		return profesor;
	}

	public static Profesor seleccionarProfesor(String DNI) throws Exception {
		String SQL = "SELECT * FROM profesor WHERE Dni = " + DNI;

		Vector<Object> profesor = get(SQL);

		Profesor prof = new Profesor(DNI, profesor.get(1).toString(),profesor.get(2).toString(),profesor.get(3).toString(),profesor.get(4).toString(),Boolean.parseBoolean(profesor.get(5).toString()));

		return prof;
	}
}
