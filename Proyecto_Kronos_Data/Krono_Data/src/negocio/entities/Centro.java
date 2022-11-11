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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
}

