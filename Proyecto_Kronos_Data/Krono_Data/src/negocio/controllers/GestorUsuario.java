package negocio.controllers;
import java.util.Vector;

import negocio.entities.*;
import persistencia.EstudianteDAO;
import persistencia.ProfesorDAO;
import persistencia.UsuarioDAO;
public class GestorUsuario {
	public boolean login(String DNI,String Contraseña) throws Exception {
		boolean login=false;
		Usuario usuario = UsuarioDAO.seleccionarUsuario(DNI);
		if(usuario.getContrasena().equals(Contraseña)) {
			login=true;
			switch(usuario.getTipo()) {
			case "E":
				System.out.println("Estudiante");
				Estudiante estudiante = EstudianteDAO.seleccionarEstudiante(DNI);
				
				break;
			case "P":
				System.out.println("Profesor");
				Profesor profesor= ProfesorDAO.seleccionarProfesor(DNI);
				
				break;
			case "G":
				System.out.println("Jefe de Gabinete de Vicerrectorado");
				break;
			case "J":
				System.out.println("Personal de Vicerrectorado");

				break;
			default:
				break;
			}
		}
		
		return login;
	}

}
