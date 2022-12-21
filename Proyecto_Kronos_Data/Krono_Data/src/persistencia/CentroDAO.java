package persistencia;

import java.util.Vector;

import negocio.entities.Centro;
import presentacion.PantallaErrores;

public class CentroDAO {
	

	public static Centro seleccionarCentro(String nombre) {
		Centro ce = null;
		try {
			String sql = "SELECT * FROM dbo.Centro WHERE Nombre = '" + nombre + "'";

			Vector<Object> centro;

			centro = GestorBD.oneExecuteQuery(sql);

			ce = new Centro(nombre, centro.get(1).toString());

			return ce;
		} catch (Exception e) {
			PantallaErrores err = new PantallaErrores(e.toString());
			err.setVisible(true);
		}
		return ce;
	}
}
