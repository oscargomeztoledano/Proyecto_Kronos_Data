package negocio.entities;

import java.util.*;

public class Centro {

	Collection<CursoPropio> cursoPropios;
	Collection<ProfesorUCLM> plantilla;
	private String nombre;
	private String localizacion;
	public Centro(String nombre,String localizacion) {
		this.nombre=nombre;
		this.localizacion=localizacion;
		}
}

