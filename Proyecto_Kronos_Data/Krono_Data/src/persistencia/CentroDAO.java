package persistencia;

import java.util.Vector;

import negocio.entities.Centro;
import net.ucanaccess.util.Logger;

public class CentroDAO {
	public static Vector<Object> getOne(String sql) throws Exception {

		return GestorBD.oneExecuteQuery(sql);
	}

	public static Centro seleccionarCentro(String nombre) {
		Centro ce = null;
		try {
			String sql = "SELECT * FROM Centro WHERE Nombre = \'" + nombre + "\'";

			Vector<Object> centro;

			centro = getOne(sql);

			ce = new Centro(nombre, centro.get(1).toString());

			return ce;
		} catch (Exception e) {
			Logger.log("mensaje de error");
		}
		return ce;
	}
}
