package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
 
import presentacion.PantallaErrores;

public class GestorBD {
	protected static GestorBD mInstancia = null;
	// Conexion con la base de datos
	protected static Connection mBD;

	// Driven para conectar con bases de datos MySQL
	
	private static String driver1 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static Connection getRemoteConnection() throws ClassNotFoundException, SQLException  {
		Connection con = null;
		try {
			Class.forName(driver1);
			 
	
			String user="KronoUCLM";
			String pass="Krono_data";
			String connectionUrl = "jdbc:sqlserver://krono-data.database.windows.net:1433;"+"databaseName=Krono_Data;"  
					 + "encrypt=true;"
					+ "trustServerCertificate=false;" + "loginTimeout=30;";

			con = DriverManager.getConnection(connectionUrl,user,pass);

		} catch (Exception e) {
			PantallaErrores err = new PantallaErrores(e.toString());
			err.setVisible(true);

			
		}
		return con;
	}

	public static void conectarBD() throws ClassNotFoundException, SQLException {
		try {
			
			
			Class.forName(driver1);
			mBD = getRemoteConnection();
			if(mBD != null) {
			mBD.setAutoCommit(true);
			}
		} catch (Exception e) {
			PantallaErrores err = new PantallaErrores(e.toString());
			err.setVisible(true);
		}

	}

	public static void desconectarBD() throws SQLException {
		try {
			mBD.close();

		} catch (Exception e) {
			PantallaErrores err = new PantallaErrores(e.toString());
			err.setVisible(true);
		}

	}

	public static Vector<Object> executeQuery(String sql) throws ClassNotFoundException { // Sacar datos de BD
		try(Statement st = mBD.createStatement()) {

			conectarBD();
			ResultSet result = st.executeQuery(sql);
			Vector<Object> v = obtenerResulset(result);
			desconectarBD();
			return v;
		} catch (SQLException e) {
			
			PantallaErrores err = new PantallaErrores(e.toString());
			err.setVisible(true);
			return null;
		}
	}

	public static Vector<Object> oneExecuteQuery(String sql) throws Exception {
		try (Statement st = mBD.createStatement()){

			conectarBD();
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
		try (Statement st = mBD.createStatement()){

			conectarBD();
			st.executeUpdate(sql);
			st.close();
			desconectarBD();
			resultado = 1;
		} catch (SQLException e) {
			PantallaErrores err = new PantallaErrores(e.toString());
			err.setVisible(true);
			resultado = 0;
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
					continue;
				}
			}
		}

		return v;
	}
}