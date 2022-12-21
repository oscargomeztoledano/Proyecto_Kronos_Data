package persistencia;

import java.util.Vector;

import negocio.entities.CategoriaProfesor;
import negocio.entities.Profesor;
import negocio.entities.ProfesorExterno;
import negocio.entities.ProfesorUCLM;
import negocio.entities.Usuario;

public class ProfesorDAO {

	

	public static Profesor seleccionarProfesor(Usuario usuario) throws Exception {
		Profesor pro=null;
		String sql = "SELECT * FROM dbo.Profesor WHERE Dni = '"+usuario.getDNI()+"'";

		Vector<Object> profesor = GestorBD.oneExecuteQuery(sql);
     
		if(profesor.size()!=0) {
			pro=new Profesor(usuario.getDNI(),usuario.getContrasena(),usuario.getTipo(), profesor.get(1).toString(),profesor.get(2).toString(),Boolean.parseBoolean(profesor.get(3).toString()));
		}
		return pro;
	}
	public static ProfesorUCLM seleccionarProfesorUCLM(Profesor profesor) throws Exception {
		ProfesorUCLM proUCLM=null;
		String sql = "SELECT * FROM profesoruclm WHERE Dni = '"+profesor.getDNI()+"'";

		Vector<Object> profesorUCLM = GestorBD.oneExecuteQuery(sql);
		      if(profesorUCLM.size()!=0) {
		    	  proUCLM=new ProfesorUCLM(profesor.getDNI(),profesor.getContrasena(),profesor.getTipo(),profesor.getNombre(),profesor.getApellidos(),profesor.isDoctor(),comparacionCategoriaProfesor(profesorUCLM.get(1).toString()),CentroDAO.seleccionarCentro(profesorUCLM.get(2).toString()));

		      }
		      return proUCLM;
	}
	public static ProfesorExterno seleccionarProfesorExterno(Profesor profesor) throws Exception {
		ProfesorExterno proEx=null;

		String sql = "SELECT * FROM profesorexterno WHERE dniprofesorExterno = '"+profesor.getDNI()+"'";

		Vector<Object> profesorExterno = GestorBD.oneExecuteQuery(sql);
		 if(profesorExterno.size()!=0) {
			 proEx=new ProfesorExterno(profesor.getDNI(),profesor.getContrasena(),profesor.getTipo(),profesor.getNombre(),profesor.getApellidos(),profesor.isDoctor(),profesorExterno.get(1).toString());

	      }
		 return proEx;

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
