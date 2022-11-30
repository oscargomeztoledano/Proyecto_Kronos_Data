package persistencia;

import java.text.SimpleDateFormat;
import java.util.Vector;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;
import negocio.entities.CursoPropio;
import negocio.entities.Matricula;
import presentacion.PantallaMatriculacion;

public class MatriculaDAO {

	public static int insert(Matricula mat) {
		int resultadoMatricula = 0;
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
			resultadoMatricula = GestorBD.executeUpdate(sql);

		} catch (ClassNotFoundException e) {

			PantallaMatriculacion.jTextArea1.setText("Ha ocurrido un problema al realizar la matricula");

		}
		return resultadoMatricula;
	}
	
	public static Collection obtenerMatriculasCurso(CursoPropio curso) throws ClassNotFoundException{
		String sql = "SELECT * FROM Matriculas WHERE CursoId = '" + curso.getId() + "'";
		Vector<Object> matriculas = GestorBD.executeQuery(sql);
		Collection mat;
		
		while(!matriculas.isEmpty()) {
			Vector<Object> v = (Vector<Object>) matriculas.get(0);
			//Matricula m = new Matricula(curso, EstudianteDAO.seleccionarEstudiante(v.get(1).toString()), (Date) v.get(2), (boolean) v.get(3));
		}
		
		return null;
	}
}
