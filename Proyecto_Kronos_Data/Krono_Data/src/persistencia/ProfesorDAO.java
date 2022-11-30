package persistencia;

import java.util.Vector;

import negocio.entities.CategoriaProfesor;
import negocio.entities.Profesor;
import negocio.entities.ProfesorUCLM;
import negocio.entities.Usuario;

public class ProfesorDAO {
	public static Vector<Object> get(String sql) throws Exception {

		return GestorBD.executeQuery(sql);
	}
	public static Vector<Object> getOne(String sql) throws Exception {

		return GestorBD.oneExecuteQuery(sql);
	}

	public static Profesor seleccionarProfesor(Usuario usuario) throws Exception {
		String sql = "SELECT * FROM Profesor WHERE Dni = \'"+usuario.getDNI()+"\'";

		Vector<Object> profesor = getOne(sql);
     
		return new Profesor(usuario.getDNI(),usuario.getContrasena(),usuario.getTipo(), profesor.get(1).toString(),profesor.get(2).toString(),Boolean.parseBoolean(profesor.get(3).toString()));
	}
	public static ProfesorUCLM seleccionarProfesorUCLM(Profesor profesor) throws Exception {
		String sql = "SELECT * FROM ProfesorUCLM WHERE Dni = \'"+profesor.getDNI()+"\'";

		Vector<Object> profesorUCLM = getOne(sql);
		      
		return new ProfesorUCLM(profesor.getDNI(),profesor.getContrasena(),profesor.getTipo(),profesor.getNombre(),profesor.getApellidos(),profesor.isDoctor(),comparacionCategoriaProfesor(profesorUCLM.get(1).toString()),CentroDAO.seleccionarCentro(profesorUCLM.get(2).toString()));

	}
	
	public static CategoriaProfesor comparacionCategoriaProfesor(String categoriaprofesor) {
		CategoriaProfesor categoria = null;
		switch (categoriaprofesor) {
		case "ASOCIADO":
			categoria = CategoriaProfesor.ASOCIADO;
			break;
		case "AYUDANTE":
			categoria = CategoriaProfesor.AYUDANTE;
			break;
		case "AYUDANTE_DOCTOR":
			categoria = CategoriaProfesor.AYUDANTE_DOCTOR;

			break;
		case "CATEDRATICO":
			categoria = CategoriaProfesor.CATEDRATICO;

			break;
		case "TITULAR_UNIVERSIDAD":
			categoria = CategoriaProfesor.TITULAR_UNIVERSIDAD;
			break;
	case "CONTRATADO_DOCTOR":
		categoria = CategoriaProfesor.CONTRATADO_DOCTOR;
		break;
	

	}
		return categoria;

	}
}
