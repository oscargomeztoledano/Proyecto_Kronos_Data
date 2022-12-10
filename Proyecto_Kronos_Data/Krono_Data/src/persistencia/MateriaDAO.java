package persistencia;

import java.text.SimpleDateFormat;
import java.util.Vector;

import negocio.entities.CursoPropio;
import negocio.entities.Materia;

public class MateriaDAO {
	public static Vector<Object> getOne(String sql) throws Exception {

		return GestorBD.oneExecuteQuery(sql);
	}

	public static int insertarMateriaCurso(Materia materia, CursoPropio curso) {
		int resultado = 0;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String fechaIn = formatter.format(materia.getFechaInicio());
		String fechaFinal = formatter.format(materia.getFechaFin());
		try {
			String sql = "INSERT INTO titulospropiosuclm2022.Materia (Nombre, Horas, fechaInicio, fechaFin, CursoId, dniProfesor) VALUES"
					+ " ('"+ materia.getNombre() +"', "+ materia.getHoras() +", '"+ fechaIn +"', '"+ fechaFinal +"', '"+ curso.getId() +"', "
							+"'"+ materia.getResponsable().getDNI() +"')";

			resultado = GestorBD.executeUpdate(sql);


			return resultado;
		} catch (Exception e) {
			//Logger.log("mensaje de error");
		}
		return resultado;
	}
}
