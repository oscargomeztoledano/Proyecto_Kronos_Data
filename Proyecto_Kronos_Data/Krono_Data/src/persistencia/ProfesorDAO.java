package persistencia;

import java.util.Vector;

import negocio.entities.CategoriaProfesor;
import negocio.entities.Profesor;
import negocio.entities.ProfesorUCLM;
import negocio.entities.TipoCurso;
import negocio.entities.Usuario;

public class ProfesorDAO {
	public static Vector<Object> get(String SQL) throws Exception {
		Vector<Object> profesor = GestorBD.ExecuteQuery(SQL);

		return profesor;
	}
	public static Vector<Object> getOne(String SQL) throws Exception {
		Vector<Object> profesor = GestorBD.oneExecuteQuery(SQL);

		return profesor;
	}

	public static Profesor seleccionarProfesor(Usuario usuario,String DNI) throws Exception {
		String SQL = "SELECT * FROM profesor WHERE Dni = \'"+DNI+"\'";

		Vector<Object> profesor = getOne(SQL);

		Profesor prof = new Profesor(DNI,usuario.getContrasena(),usuario.getTipo(), profesor.get(1).toString(),profesor.get(2).toString(),Boolean.parseBoolean(profesor.get(3).toString()));
        prof.toString();
		return prof;
	}
	public static ProfesorUCLM seleccionarProfesorUCLM(Profesor profesor,String DNI) throws Exception {
		String SQL = "SELECT * FROM profesoruclm WHERE Dni = \'"+DNI+"\'";

		Vector<Object> profesorUCLM = getOne(SQL);
		
		ProfesorUCLM prof = new ProfesorUCLM(DNI,profesor.getContrasena(),profesor.getTipo(),profesor.getNombre(),profesor.getApellidos(),profesor.isDoctor(),ComparacionCategoriaProfesor(profesorUCLM.get(1).toString()),CentroDAO.seleccionarCentro(profesorUCLM.get(2).toString()));
        
		return prof;
	}
	
	public static CategoriaProfesor ComparacionCategoriaProfesor(String categoriaprofesor) {
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
