package persistencia;

import java.util.Vector;
import negocio.entities.Matricula;

public class MatriculaDAO {

	public Vector<Object> get(String s) throws Exception {

		return null;
	}

	public static void insert(Matricula mat) throws ClassNotFoundException {
		String sql = "INSERT INTO Matricula (CursoId, DniAlumno, fecha, pagado) VALUES ( '" + mat.getTitulo().getId()
				+ "', " + mat.getEstudiante().getDNI() + ", '" + mat.getFecha() + "', " + mat.isPagado() + ")";
		GestorBD.ExecuteUpdate(sql);

	}

}
