package persistencia;

import java.util.Vector;

import negocio.entities.Centro;

public class CentroDAO {
	public static Vector<Object> get(String SQL) throws Exception {
		Vector<Object> centro = GestorBD.oneExecuteQuery(SQL);

		return centro;
	}

	public static Centro seleccionarCentro(String Nombre) {
		Centro ce = null;
		try {
			String SQL = "SELECT * FROM centro WHERE nombre = \'" + Nombre + "\'";

			Vector<Object> centro;

			centro = get(SQL);

			ce = new Centro(Nombre, centro.get(1).toString());

			return ce;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ce;
	}
}
