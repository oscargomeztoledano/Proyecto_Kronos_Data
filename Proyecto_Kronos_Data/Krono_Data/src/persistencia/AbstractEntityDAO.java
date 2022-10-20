package persistencia;

import java.sql.SQLException;

import negocio.entities.Usuario;

public abstract class AbstractEntityDAO<E> {

	public E get(String s) throws ClassNotFoundException, SQLException {
		return null;		
	}

	public E insert(E entity) {
		return null;
		
	}

	public E update(E entity) {
		return entity;
	
	}

	public E delete(E entity) {
		return null;
	}

	public void operation() {
		
	}

}