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
	public static Connection getRemoteConnection()  {
		Connection con = null;
		try {
			Class.forName(driver1);
			 
	
			String user="KronoUCLM";
			String pass="Krono_data";
			String connectionUrl = "jdbc:sqlserver://krono-data.database.windows.net:1433;"+"databaseName=Krono_Data;"  
					 + "encrypt=true;"
					+ "trustServerCertificate=false;" + "loginTimeout=30;";

			con = DriverManager.getConnection(connectionUrl,user,pass);

			return con;

		} catch (SQLException e) {
			PantallaErrores err = new PantallaErrores(e.toString());
			err.setVisible(true);

			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			PantallaErrores err = new PantallaErrores(e.toString());
			err.setVisible(true);
		}
		return con;
	}

	public static void conectarBD()  {
		try {
			
			
			Class.forName(driver1);


			mBD = getRemoteConnection();
			mBD.setAutoCommit(true);

		} catch (Exception e) {
			PantallaErrores err = new PantallaErrores(e.toString());
			err.setVisible(true);
		}

	}

	public static void desconectarBD() {
		try {
			mBD.close();

		} catch (Exception e) {
			PantallaErrores err = new PantallaErrores(e.toString());
			err.setVisible(true);
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

	public static Vector<Object> oneExecuteQuery(String sql)  {
		try {

			conectarBD();
			Statement st = mBD.createStatement();
			ResultSet result = st.executeQuery(sql);
			Vector<Object> v = oneResulset(result);
			st.close();
			desconectarBD();
			return v;
		} catch (Exception e) {
			
			PantallaErrores err = new PantallaErrores(e.toString());
			err.setVisible(true);
			return null;
		}
	}

	public static int executeUpdate(String sql)  { // Updates a BD
		int resultado = 0;
		try {

			conectarBD();
			Statement st = mBD.createStatement();
			st.executeUpdate(sql);
			st.close();
			desconectarBD();
			resultado = 1;
		} catch (Exception e) {
			PantallaErrores err = new PantallaErrores(e.toString());
			err.setVisible(true);
			resultado = 0;
		}
		return resultado;
	}

	public static Vector<Object> obtenerResulset(ResultSet result) {
		Vector<Object> vectoradevolver = new Vector<>();
		try {
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
		} catch (SQLException e) {
		
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