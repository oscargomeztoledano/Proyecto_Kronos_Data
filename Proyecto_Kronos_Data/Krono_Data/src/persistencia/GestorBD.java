package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import net.ucanaccess.util.Logger;
import presentacion.PantallaErrores;

public class GestorBD {
	protected static GestorBD mInstancia = null;
	// Conexion con la base de datos
	protected static Connection mBD;
	// Identificador ODBC de la base de datos
	private static String url = "titulospropiosuclm2022.cq9ufzvy2if8.eu-west-3.rds.amazonaws.com";
	// Driven para conectar con bases de datos MySQL
	private static String driver2 = "org.postgresql.Driver";
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String user = "admin";
	private static String password = "admin1234";

	private static Connection getRemoteConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			String dbName = "titulospropiosuclm2022";
			String userName = "admin";
			String password = "admin1234";
			String hostname = "titulospropiosuclm2022.cq9ufzvy2if8.eu-west-3.rds.amazonaws.com";
			String port = "3306";
			String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password="
					+ password;

			con = DriverManager.getConnection(jdbcUrl);

			return con;
		} catch (ClassNotFoundException e) {
			Logger.log("mensaje de error");
		} catch (SQLException e) {
			Logger.log("mensaje de error");
		}
		return con;
	}

	public static void conectarBD() throws ClassNotFoundException, SQLException {
		try {
			Class.forName(driver);
			mBD = getRemoteConnection();
			mBD.setAutoCommit(true);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void desconectarBD() throws SQLException {
		try {
			mBD.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static Vector<Object> executeQuery(String sql) throws ClassNotFoundException { // Sacar datos de BD
		try {

			conectarBD();
			Statement st = mBD.createStatement();
			ResultSet result = st.executeQuery(sql);
			Vector<Object> v = obtenerResulset(result);
			st.close();
			desconectarBD();
			return v;
		} catch (SQLException e) {
			PantallaErrores err = new PantallaErrores(e.toString());
			err.setVisible(true);
			return null;
		}
	}

	public static Vector<Object> oneExecuteQuery(String sql) throws Exception {
		try {

			conectarBD();
			Statement st = mBD.createStatement();
			ResultSet result = st.executeQuery(sql);
			Vector<Object> v = oneResulset(result);
			st.close();
			desconectarBD();
			return v;
		} catch (SQLException e) {
			PantallaErrores err = new PantallaErrores(e.toString());
			err.setVisible(true);
			return null;
		}
	}

	public static int executeUpdate(String sql) throws ClassNotFoundException { // Updates a BD
		int resultado = 0;
		try {

			conectarBD();
			Statement st = mBD.createStatement();
			st.executeUpdate(sql);
			st.close();
			desconectarBD();
			resultado = 1;
		} catch (SQLException e) {
			PantallaErrores err = new PantallaErrores(e.toString());
			err.setVisible(true);
			resultado = 0;
			e.printStackTrace();
		}
		return resultado;
	}

	public static Vector<Object> obtenerResulset(ResultSet result) throws SQLException {
		Vector<Object> vectoradevolver = new Vector<>();
		while (result.next()) {
			Vector<Object> v = new Vector<>();
			int i = 1;
			while (true) {
				try {
					v.add(result.getObject(i));
					i++;
				} catch (SQLException ex) {
					break;
				}
			}
			vectoradevolver.add(v);
		}
		return vectoradevolver;
	}

	public static Vector<Object> oneResulset(ResultSet result) throws SQLException {
		Vector<Object> v = new Vector<>();

		while (result.next()) {
			for (int i = 1; i < 20; i++) {
				try {
					v.add(result.getObject(i));

				} catch (SQLException ex) {
					System.out.println(ex);
				}
			}
		}

		return v;
	}
}