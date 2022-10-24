package persistencia;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Vector;

public class GestorBD {
	protected static GestorBD mInstancia = null;
	// Conexion con la base de datos
	protected static Connection mBD;
	// Identificador ODBC de la base de datos
	private static String url = "jdbc:mysql://localhost:3306/titulospropiosuclm2022";
	// Driven para conectar con bases de datos MySQL

	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String user = "root";
	private static String password = "victor";

	public static void conectarBD() throws ClassNotFoundException, SQLException {
		try {
			Class.forName(driver);
			mBD = DriverManager.getConnection(url, user, password);
			mBD.setAutoCommit(true);
			System.out.println("Conectado");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void desconectarBD() throws SQLException {
		try {
			mBD.close();
			System.out.println("Desconectado");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static Vector<Object> ExecuteQuery(String SQL) throws ClassNotFoundException { // Sacar datos de BD
		try {
			conectarBD();
			Statement st = mBD.createStatement();
			ResultSet result = st.executeQuery(SQL);
			Vector<Object> v = obtenerResulset(result);
			st.close();
			desconectarBD();
			return v;
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}

	public static Vector<Object> oneExecuteQuery(String SQL) throws Exception {
		try {
			conectarBD();
			Statement st = mBD.createStatement();
			ResultSet result = st.executeQuery(SQL);
			Vector<Object> v = OneResulset(result);
			st.close();
			desconectarBD();
			return v;
		} catch (SQLException e) {
			return null;
		}
	}

	public static void ExecuteUpdate(String SQL) throws ClassNotFoundException { // Updates a BD
		try {
			conectarBD();
			Statement st = mBD.createStatement();
			st.executeUpdate(SQL);
			st.close();
			desconectarBD();
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

	public static Vector<Object> obtenerResulset(ResultSet result) throws SQLException {
		Vector<Object> vectoradevolver = new Vector<Object>();
		while (result.next()) {
			Vector<Object> v = new Vector<Object>();
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

	public static Vector<Object> OneResulset(ResultSet result) throws SQLException {
		Vector<Object> v = new Vector<Object>();
		int i = 1;
		while (result.next()) {
			v.add(result.getObject(i));
			i++;
		}
		return v;
	}
}
