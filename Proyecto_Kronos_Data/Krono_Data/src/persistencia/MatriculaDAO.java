package persistencia;

import java.text.SimpleDateFormat;
import java.util.Vector;
import negocio.entities.Matricula;
import presentacion.PantallaMatriculacion;

public class MatriculaDAO {

	public static void insert(Matricula mat)  {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String fechaTexto = formatter.format(mat.getFecha());
		int bit;
		if (mat.isPagado()) {
			bit = 1;
		} else {
			bit = 0;
		}
		String sql = "INSERT INTO Matricula (CursoId, DniAlumno, fecha, pagado) VALUES ( '" + mat.getTitulo().getId()
				+ "', '" + mat.getEstudiante().getDNI() + "', '" + fechaTexto + "'," + bit + ")";
		try {
			GestorBD.ExecuteUpdate(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			PantallaMatriculacion.jTextArea1.setText("Ha ocurrido un problema al realizar la matricula");
		}

	}
}
